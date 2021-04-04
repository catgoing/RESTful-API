package com.weather.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class Weather {
	
	private String fc_date;				//예보일
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
	private int temp_0;					//0시 기온
	private int temp_3;					//3시 기온
	private int temp_6;					//6시 기온
	private int temp_9;					//9시 기온
	private int temp_12;				//12시 기온
	private int temp_15;				//15시 기온
	private int temp_18;				//18시 기온
	private int temp_21;				//21시 기온
	

}
