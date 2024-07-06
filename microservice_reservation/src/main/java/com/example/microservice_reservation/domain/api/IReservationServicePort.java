package com.example.microservice_reservation.domain.api;

import com.example.microservice_reservation.domain.model.Reservation;

public interface IReservationServicePort {
    void saveReservation(Reservation reservation);
}
