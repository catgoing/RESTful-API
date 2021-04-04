package com.weather.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.weather.exception.APIException;
import com.weather.exception.ErrorNum;
import com.weather.service.Weather;
import com.weather.service.WeatherDAO;

@RestController
@MapperScan(basePackages="com.weather.service")
public class APIController {
	@Autowired
	private WeatherDAO weatherDAO;
		
	SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
	
	Date date_today = new Date();
	Date date_tomorrow = new Date(date_today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ));
	String today = timeFormat.format(date_today);
	String tomorrow = timeFormat.format(date_tomorrow);

	@RequestMapping(value = "/weather/today", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Weather> todayWeatherLocal(@RequestParam(value="local", defaultValue = "")String local_name) { //query String으로 지역이름을 받도록 설정
		Weather param = new Weather();
		param.setFc_date(today);
		param.setLocal_name(local_name);
		List<Weather> weatherList = weatherDAO.selectWeather(param);// 22번 째 줄에서 생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록을 불러온다.
		if(weatherList.size() == 0) {
			throw new APIException(ErrorNum.RUNTIME_EXCEPTION);
		}
		return weatherList;
	}
	
	@RequestMapping(value = "/weather/tomorrow", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Weather> tomorrowWeatherLocal(@RequestParam(value="local", defaultValue = "")String local_name) { //query String으로 지역이름을 받도록 설정
		Weather param = new Weather();
		param.setFc_date(tomorrow);
		param.setLocal_name(local_name);
		List<Weather> weatherList = weatherDAO.selectWeather(param);// 생성한 Weather 객체를 파라미터로 전달하여 DB로부터 내일 기상을 불러온다.
		if(weatherList.size() == 0) {
			throw new APIException(ErrorNum.RUNTIME_EXCEPTION);
		}
		
		return weatherList;
	}
	
	@PostMapping(value = "/weather")
	@ResponseStatus(value = HttpStatus.OK)
	public String postWeather(@RequestBody Weather param) {
		int result = weatherDAO.insertWeather(param);// 생성한 Weather 객체를 파라미터로 전달하여 DB로부터 내일 기상을 조회
		if(result == 0) {
			throw new APIException(ErrorNum.DATA_EXCEPTION);
		}
		return result + "건 입력 완료";
	}
	
	@PutMapping(value = "/weather")
	@ResponseStatus(value = HttpStatus.OK)
	public String putWeather(@RequestBody Weather param) {
		int result = weatherDAO.updateWeather(param);// 생성한 Weather 객체를 파라미터로 전달하여 DB에서 해당 기상을 수정
		if(result == 0) {
			throw new APIException(ErrorNum.DATA_EXCEPTION);
		}
		return result + "건 수정 완료";
	}
	
	@DeleteMapping(value = "/weather")
	@ResponseStatus(value = HttpStatus.OK)
	public String deleteWeather(@RequestBody Weather param) {
		int result = weatherDAO.deleteWeather(param);// 생성한 Weather 객체를 파라미터로 전달하여 DB로부터 해당 기상을 삭제
		if(result == 0) {
			throw new APIException(ErrorNum.DATA_EXCEPTION);
		}
		return result + "건 삭제 완료";
	}
	

	@RequestMapping(value = "/**", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public void wrongRequest() { //잘못된 요청 통합처리
		throw new APIException(ErrorNum.RUNTIME_EXCEPTION);

	}

}
