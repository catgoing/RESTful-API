package com.weather.demo;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weather.service.Weather;
import com.weather.service.WeatherDAO;

@RestController
@MapperScan(basePackages="com.weather.service")
public class APIController {
	@Autowired
	private WeatherDAO weatherDAO;
	
	@RequestMapping(value = "/today", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Weather> weather(@RequestParam(value="local", defaultValue = "")String local_name) { //query String으로 county를 받도록 설정
		final Weather param = new Weather(local_name, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);//전달 받은 local_name을 받은 Weather 객체 생성, 이 객체는 MyBatis에 파라미터로 전달
		final List<Weather> weatherList = weatherDAO.selectWeather(param);// 22번 째 줄에서 생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록을 불러온다.
		return weatherList;
	}

}
