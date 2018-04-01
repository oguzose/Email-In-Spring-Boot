package com.ozkaraca.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ozkaraca.mail.domain.User;


@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException{
		//send mail
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("danvega@gmail.com");
		mail.setSubject("This is example");
		mail.setText("Coll email dude..");
		
		javaMailSender.send(mail);
	}
	
	

}
