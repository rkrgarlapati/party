package com.roche.soa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mpulicke on 11/8/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private final String errorCode;
    private final String errorMessageCode;

    public NotFoundException(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessageCode = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessageCode() {
        return errorMessageCode;
    }
}
