package com.palex.Rest;

import com.palex.Rest.view.ErrorResponseView;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Перехват ResponseEntityException
 */
@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Перехват ответа на исключения типа MethodArgumentNotValidException
     *
     * @param ex      - объект исключения.
     * @param headers - заголовки.
     * @param status  - http статус.
     * @param request - запрос.
     * @return Ответ клиенту.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorResponseView(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Перехват ответа на исключения типа HttpMessageNotReadableException.
     *
     * @param ex      - объект исключения.
     * @param headers - заголовки.
     * @param status  - http статус.
     * @param request - запрос.
     * @return Ответ клиенту.
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorResponseView(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Перехват всех остальных исключений типа Exception.
     *
     * @param ex - объект исключения.
     * @return - Ответ клиенту.
     */
    @ExceptionHandler(Exception.class)
    private ErrorResponseView handleOtherException(Exception ex) {
        return new ErrorResponseView(ex.getMessage());
    }
}