package com.weather.exception;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
	@Autowired
    private ErrorNum error;

    public ApiException(ErrorNum e) {
        super(e.getMessage());
        this.error = e;
    }
}