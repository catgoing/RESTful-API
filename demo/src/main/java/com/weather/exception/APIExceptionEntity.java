package com.weather.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class APIExceptionEntity {
    private String errorCode;
    private String errorMessage;

    @Builder
    public APIExceptionEntity(HttpStatus status, String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}