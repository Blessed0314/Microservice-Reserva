package com.example.microservice_reservation.domain.spi;

import com.example.microservice_reservation.domain.model.Reservation;

public interface IReservationPersistencePort {
    void saveReservation(Reservation reservation);
}
