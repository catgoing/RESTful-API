package com.weather.exception;


import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorNum {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, 
    			"E0001", "잘못된 요청입니다. 올바른 요청: get - /weather/today or /weather/tomorrow || put, post, delete - /weather"),
	DATA_EXCEPTION(HttpStatus.BAD_REQUEST, 
				"E0002", "입력 데이터 형식에 오류가 있습니다. 데이터를 다시 확인해주세요.");
// 기타 예시
//  ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
//  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
//  SECURITY_01(HttpStatus.UNAUTHORIZED, "S0001", "권한이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ErrorNum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ErrorNum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
