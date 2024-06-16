package com.uj.cinema.model.exception.screening;

import com.uj.cinema.model.exception.base.EntityNotFoundException;

public class ScreeningNotFoundException extends EntityNotFoundException {

    public ScreeningNotFoundException(final String message) {
        super(message);
    }

    public ScreeningNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}