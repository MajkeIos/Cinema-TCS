package com.uj.cinema.model.exception.screen;

import com.uj.cinema.model.exception.base.EntityNotFoundException;

public class ScreenNotFoundException extends EntityNotFoundException {

    public ScreenNotFoundException(final String message) {
        super(message);
    }

    public ScreenNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}