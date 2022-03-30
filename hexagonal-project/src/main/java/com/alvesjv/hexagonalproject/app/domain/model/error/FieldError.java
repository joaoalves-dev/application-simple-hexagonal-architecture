package com.alvesjv.hexagonalproject.app.domain.model.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldError {
    private String field;
    private String message;
    private String value;
}
