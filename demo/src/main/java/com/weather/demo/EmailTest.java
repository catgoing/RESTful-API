package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailTest {
	@Autowired
	private MailService mail;

	@RequestMapping("/email")
	public String emailtest1() {
		
		mail.sendEmail("sazya24@gmail.com", "test");

		return "/today";
	}

}
