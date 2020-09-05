package dev.serhats.shoppingcart.exception;

public class UserNotValidException extends Throwable {
    public UserNotValidException() { }

    public UserNotValidException(String field) {
        super("Please enter valid value for " + field + "field");
    }
}
