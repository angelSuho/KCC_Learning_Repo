package com.kcc.restful.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private final HttpStatus status;
    public UserNotFoundException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
