package org.hotel.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.hotel.app.dto.Api;
import org.hotel.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(Api.ALLOWED_ORIGINS)
public class OtpController {
	@Autowired
    private EmailService emailService;
	
	private Map<String, String> otpStore = new HashMap();

	    private String generateOtp() {
	        Random random = new Random();
	        return String.valueOf(100000 + random.nextInt(900000));
	    }

	    @PostMapping("/send-otp")
	    public String sendOtp(@RequestParam String email) {
	        String otp = generateOtp();
	        emailService.sendOtpEmail(email, otp);
	        otpStore.put(email, otp);
	        return otp;
	    }

}
