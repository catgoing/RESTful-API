package com.weather.exception;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
	@Autowired
    private ErrorNum error;

    public APIException(ErrorNum e) {
        super(e.getMessage());
        this.error = e;
    }
}