package dev.cryss.productrating.controllers.exceptions;

import lombok.Data;

@Data
public class CustomServiceCustomException extends RuntimeException{

    private String errorCode;

    public CustomServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}