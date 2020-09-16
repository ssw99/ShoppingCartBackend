package dev.serhats.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotValidException extends BaseException {
    public UserNotValidException() {
    }

    public UserNotValidException(String field) {
        super("Please enter valid value for " + field + "field");
    }
}
