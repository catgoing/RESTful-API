package com.weather.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@ToString
public class Weather {
	
	private String local_name;			//지역명
	private double rainfall_prob;		//강수확률
	private double rain_prec;			//일강수량
	private double min_temperature;		//최저기온
	private double max_temperature;		//최고기온
	private double avg_temperature;		//평균기온
	private int fine_dust;				//미세먼지
	private int particulate_dust;		//초미세먼지
	private int wind_sp;				//풍량
	private int wind_dr;				//풍향
	private Date reg_date;				//등록일
	

	

}
