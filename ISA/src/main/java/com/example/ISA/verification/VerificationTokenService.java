package com.example.ISA.verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VerificationTokenService {
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	
	public void save(VerificationToken verificationToken) {
        verificationTokenRepository.save(verificationToken);
    }
}
