package com.weather.service;

import java.util.List;

public interface WeatherDAO {
	
	List<Weather> selectWeather(Weather param);
	int insertWeather(Weather param);
	int deleteWeather(Weather param);
	int updateWeather(Weather param);

}
