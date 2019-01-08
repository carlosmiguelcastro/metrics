package com.mango.swaggertraining.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ApiError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ApiError setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ApiError setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public ApiError setError(String error) {
        this.error = error;
        return this;
    }

    public String getException() {
        return exception;
    }

    public ApiError setException(String exception) {
        this.exception = exception;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public ApiError setPath(String path) {
        this.path = path;
        return this;
    }
}
