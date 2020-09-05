package dev.serhats.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException() {
    }
    public EntityNotFoundException(String message) {
        super(message);
    }
}
