package com.example.ISA.service;

import com.example.ISA.model.Profile;
import com.example.ISA.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Profile getProfileByEmail(String email) {
        List<Profile> allProfiles = this.userProfileRepository.findAll();
        for (Profile profile : allProfiles) {
            if (profile.getUser().getEmail().equals(email)) {
                return profile;
            }
        }
        return null;
    }

}
