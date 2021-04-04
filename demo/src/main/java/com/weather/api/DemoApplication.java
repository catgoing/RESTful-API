package com.weather.api;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@ComponentScan(basePackages = "com.weather")

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	
	//MyBatis 사용을 위한 설정
	  @Bean
	  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(dataSource);
			
			Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper.xml");
			sessionFactory.setMapperLocations(res);
			
			return sessionFactory.getObject();
		}
	  
	//서버가 내려갈 때 동작할 Bean 생성
	  @Bean
	  public ShutDownCustom shutdown() { 
	    return new ShutDownCustom();
	  }

}
