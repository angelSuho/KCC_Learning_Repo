package com.kcc.restful.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private LocalDate timestamp;
    private String message;
    private String details;
}
