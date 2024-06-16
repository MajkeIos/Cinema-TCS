package com.uj.cinema.model.exception.theater;

import com.uj.cinema.model.exception.base.EntityNotFoundException;

public class TheaterNotFoundException extends EntityNotFoundException {

    public TheaterNotFoundException(final String message) {
        super(message);
    }

    public TheaterNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}
