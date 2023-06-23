package com.calendar.sejin.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiResult<T> {
    private int code;
    private HttpStatus status;
    private String message;
    private T data;

    public static <T> ApiResult<T> created(String message, T data) {
        return of(HttpStatus.CREATED, message, data);
    }

    public static <T> ApiResult<T> ok(String message, T data) {
        return of(HttpStatus.OK, message, data);
    }

    public static <T> ApiResult<T> noContent(String message) {
        return of(HttpStatus.NO_CONTENT, message, null);
    }

    public static <T> ApiResult<T> of(HttpStatus status, String message, T data) {
        return new ApiResult<>(status.value(), status, message, data);
    }

    public static <T> ApiResult<T> badRequest(String message) {
        return of(HttpStatus.BAD_REQUEST, message, null);
    }
}
