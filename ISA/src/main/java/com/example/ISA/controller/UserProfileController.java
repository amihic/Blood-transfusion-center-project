package com.example.ISA.controller;

import com.example.ISA.model.Profile;
import com.example.ISA.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "/{email}", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Profile> getProfile(@PathVariable String email){
        Profile profile = this.userProfileService.getProfileByEmail(email);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

}
