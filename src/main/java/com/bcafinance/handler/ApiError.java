package com.bcafinance.handler;

import com.bcafinance.utils.ConstantMessage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    private HttpStatus serverResponse;
    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private List<ApiValidationError> subErrors;
    private String errorCode;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    ApiError(HttpStatus serverResponse) {
        this();
        this.serverResponse = serverResponse;
    }

    ApiError(HttpStatus serverResponse, Throwable ex) {
        this();
        this.serverResponse = serverResponse;
        this.message = ConstantMessage.ERROR_UNEXPECTED;
//        this.debugMessage = ex.getMessage();
    }

//    ApiError(HttpStatus serverResponse, String message, Throwable ex,String path,String errorCode) {
    ApiError(HttpStatus serverResponse, String message, Throwable ex,String path,String errorCode) {
        this();
        this.serverResponse = serverResponse;
        this.message = message;
        this.path = path;
        this.errorCode=errorCode;
    }

    public int getStatus() {
        return serverResponse.value();
    }
}
