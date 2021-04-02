package com.weather.demo;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class ServletContextListener implements WebMvcConfigurer{
//
//	@Bean 
//	ServletListenerRegistrationBean<ServletContextListener> servletListener() { 
//		
//		ServletListenerRegistrationBean<ServletContextListener> srb = new ServletListenerRegistrationBean<>(); 
//		srb.setListener(new MyServletContextListener()); 
//		return srb; 
//		
//	}
//
//
//}
