package com.ozkaraca.mail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozkaraca.mail.domain.User;
import com.ozkaraca.mail.service.NotificationService;

@RestController
public class RegistrationController {
	
	private Logger log = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private NotificationService notificanService;
	
	@RequestMapping("/signup")
	public String signup() {
		return "please sign up";
	}
	
	@RequestMapping("/signup-success")
	public String signin() {
		
		User user = new User();
		user.setFirstName("oguz");
		user.setEmail("oguzozkaraca@gmail.com");
		user.setLastName("ozkzraca");
		
		try {
			notificanService.sendNotification(user);
		} catch (MailException e) {
			log.info("***-- exeption: " + e.getMessage());
		}
				
		return "thank you registration for us";
	}

}
