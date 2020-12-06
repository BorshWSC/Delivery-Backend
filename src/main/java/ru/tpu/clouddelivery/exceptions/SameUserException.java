package ru.tpu.clouddelivery.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class SameUserException extends RuntimeException {
    public SameUserException(String text) {
        super(text);
    }
}
