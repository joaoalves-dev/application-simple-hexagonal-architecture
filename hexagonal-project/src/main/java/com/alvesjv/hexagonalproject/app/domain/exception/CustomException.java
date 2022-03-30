package com.alvesjv.hexagonalproject.app.domain.exception;

public class CustomException extends RuntimeException{

    public CustomException(final Throwable t){
        super(t);
    }
}
