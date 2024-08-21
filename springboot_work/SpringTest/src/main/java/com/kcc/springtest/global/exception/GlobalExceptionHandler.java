//package com.kcc.springtest.global.exception;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.time.LocalDateTime;
//
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException e) {
//        log.error("handleRuntimeException", e);
//        ExceptionResponse exceptionResponse = new ExceptionResponse("Internal Server Error",
//                HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now().toString());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException e) {
//        log.error("handleNotFoundException", e);
//        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(),
//                e.getCode(), LocalDateTime.now().toString());
//        return ResponseEntity.status(e.getCode()).body(exceptionResponse);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        ExceptionResponse response = new ExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now().toString());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//}
