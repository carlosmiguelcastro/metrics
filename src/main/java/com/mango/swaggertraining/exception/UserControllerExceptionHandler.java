package com.mango.swaggertraining.exception;

import com.mango.swaggertraining.exception.ApiError;
import com.mango.swaggertraining.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class UserControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiError> handleNotFoundException(RuntimeException exception,
                                                            HttpServletRequest httpServletRequest) {
        ApiError apiError = new ApiError()
                .setTimestamp(LocalDateTime.now())
                .setStatus(HttpStatus.NOT_FOUND.value())
                .setError(HttpStatus.NOT_FOUND.getReasonPhrase())
                .setException(exception.getClass().getCanonicalName())
                .setMessage(exception.getLocalizedMessage())
                .setPath(httpServletRequest.getRequestURI());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
