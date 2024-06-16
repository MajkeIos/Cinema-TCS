package com.uj.cinema.model.exception.movie;

import com.uj.cinema.model.exception.base.EntityNotFoundException;

public class MovieNotFoundException extends EntityNotFoundException {

    public MovieNotFoundException(final String message) {
        super(message);
    }

    public MovieNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}
