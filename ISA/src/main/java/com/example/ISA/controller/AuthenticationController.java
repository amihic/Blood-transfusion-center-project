package com.example.ISA.controller;


import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.ISA.DTO.AuthenticatedUserDTO;
import com.example.ISA.DTO.UserRegistrationDTO;
import com.example.ISA.model.User;
import com.example.ISA.security.DTO.JwtAuthenticationRequest;
import com.example.ISA.security.DTO.UserTokenState;
import com.example.ISA.security.exception.ResourceConflictException;
import com.example.ISA.security.service.impl.UserServiceImpl;
import com.example.ISA.security.util.TokenUtils;
import com.example.ISA.service.EmailService;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private EmailService emailService;
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		// Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
		// AuthenticationException
		AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
        User u = userServiceImpl.findByEmail(authenticationRequest.getEmail());
        
        if(u!=null){
        	if(!u.isEnabled()) {System.out.println("User nije verifikovao nalog");}
        	
                Authentication authentication = authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                                authenticationRequest.getPassword()));

                SecurityContext ctx = SecurityContextHolder.createEmptyContext();
                SecurityContextHolder.setContext(ctx);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                User user = (User) authentication.getPrincipal();
                String jwt = tokenUtils.generateToken(user.getEmail());
                int expiresIn = tokenUtils.getExpiredIn();
                authenticatedUserDTO = new AuthenticatedUserDTO(user.getId(), user.getRole(), user.getEmail(), new UserTokenState(jwt, expiresIn));
                System.out.println("Ulogovan je user " + authenticatedUserDTO.getEmail() + " sa rolom: " + authenticatedUserDTO.getRole() );
                return new ResponseEntity<>(authenticatedUserDTO, HttpStatus.OK);
                }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRegistrationDTO userRegistrationDTO, UriComponentsBuilder ucBuilder) {

		User existUser = this.userServiceImpl.findByEmail(userRegistrationDTO.getEmail());

		if (existUser != null) {
			throw new ResourceConflictException(userRegistrationDTO.getId(), "Email already exists");
		}

		User user = this.userServiceImpl.save(userRegistrationDTO);
		//slanje mejla za verifikaciju
		try {
			emailService.sendTestMail(user);
		}
		catch( Exception e) {
			System.out.println(e.getMessage());
		}	
				
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}