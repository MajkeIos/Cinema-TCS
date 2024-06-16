package com.uj.cinema.model.exception.user;

import com.uj.cinema.model.exception.base.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}
