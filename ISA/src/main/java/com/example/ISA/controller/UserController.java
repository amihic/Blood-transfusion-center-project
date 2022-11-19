package com.example.ISA.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ISA.model.User;
import com.example.ISA.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {

        User user = userService.getUser(email);

        // user must exist
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new User(user), HttpStatus.OK);
    }

    //Izmena Podataka o Useru
    @PutMapping("/update")
    public ResponseEntity<User> UpdateUser(@RequestBody User u)
    {
        User user = this.userService.UpdateUser(u);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
}
