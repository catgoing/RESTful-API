package com.weather.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Calendar time = Calendar.getInstance();
	String nowTime = timeFormat.format(time.getTime());
	
	public void sendStartEmail(String emailAddr, String content) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailAddr);
		mail.setFrom("kbkbbitcamp@gmail.com");
		mail.setSubject("Service Start Notify" + nowTime);
		mail.setText(content);

		javaMailSender.send(mail);

	}
	
	public void sendServerDownEmail(String emailAddr, String content) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailAddr);
		mail.setFrom("kbkbbitcamp@gmail.com");
		mail.setSubject("Error Notify [Service Down]" + nowTime);
		mail.setText(content);
		
		javaMailSender.send(mail);
		
	}

}