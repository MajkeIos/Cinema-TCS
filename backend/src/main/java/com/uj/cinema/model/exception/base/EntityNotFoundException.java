package com.uj.cinema.model.exception.base;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String message) {
        super(message);
    }

    public EntityNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}