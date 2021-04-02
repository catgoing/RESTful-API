package com.weather.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//public class MyServletContextListener implements ServletContextListener {
@WebListener
  public class MyServletContextListener implements ServletContextListener {
	
	
	@Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("psy tomcat Start!!!");
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    	System.out.println("톰캣 종료");
    	new MailService().sendServerDownEmail("sazya24@gmail.com", "test");
    }

}
