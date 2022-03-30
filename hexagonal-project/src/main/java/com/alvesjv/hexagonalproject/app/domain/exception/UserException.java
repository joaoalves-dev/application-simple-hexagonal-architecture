package com.alvesjv.hexagonalproject.app.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class UserException extends RuntimeException{

    private HttpStatus status;

    public UserException(String error, HttpStatus status){
        super(error);
        this.status = status;
    }
}
