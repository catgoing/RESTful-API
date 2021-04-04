package com.weather.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@SpringBootApplication
//@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
	}
	
	  @Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
			
			Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper.xml");
			sessionFactory.setMapperLocations(res);
			
			return sessionFactory.getObject();
		}
	  
	  @Bean
	  public ShutDownCustom shutdown() {
	    return new ShutDownCustom();
	  }
//	  
//	  @Bean
//	  public ConfigurableServletWebServerFactory webServerFactory(final ShutDownCustom shutDownCustom) {
//	    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//	    factory.addConnectorCustomizers(shutDownCustom);
//	    return factory;
//	  }

}
