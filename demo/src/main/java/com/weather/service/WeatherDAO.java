package com.weather.service;

import java.util.List;

public interface WeatherDAO {
	
	List<Weather> selectWeather(Weather param);

}
