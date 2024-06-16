package com.uj.cinema.model.exception.reservation;

import com.uj.cinema.model.exception.base.EntityNotFoundException;

public class ReservationNotFoundException extends EntityNotFoundException {

    public ReservationNotFoundException(final String message) {
        super(message);
    }

    public ReservationNotFoundException(final String message, final Throwable e) {
        super(message, e);
    }
}
