package com.weather.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
		
		
	}
	
	  @Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
			
			Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper.xml");
			sessionFactory.setMapperLocations(res);
			
			return sessionFactory.getObject();
		}

}
