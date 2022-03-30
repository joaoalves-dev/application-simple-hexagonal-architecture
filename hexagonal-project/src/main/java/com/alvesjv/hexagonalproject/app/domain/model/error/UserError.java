package com.alvesjv.hexagonalproject.app.domain.model.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserError {
    private Integer status;
    private String message;
}
