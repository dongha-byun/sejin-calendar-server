package com.calendar.sejin.member.presentation;

import com.calendar.sejin.api.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberControllerAdvice {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<Object> bindException(BindException e) {
        return ApiResult.badRequest(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
