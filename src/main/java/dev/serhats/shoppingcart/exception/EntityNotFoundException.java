package dev.serhats.shoppingcart.exception;

public class EntityNotFoundException extends Throwable {
    public EntityNotFoundException() {
    }
    public EntityNotFoundException(String message) {
        super(message);
    }
}
