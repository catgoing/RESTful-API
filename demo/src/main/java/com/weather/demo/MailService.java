package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String emailAddr, String content) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailAddr);
		mail.setFrom("kbkbbitcamp@gmail.com");
		mail.setSubject("[Service] Error Notify");
		mail.setText(content);

		javaMailSender.send(mail);

	}

}