package com.example.microservice_reservation.domain.spi;

import com.example.microservice_reservation.domain.model.Reservation;

import java.util.List;

public interface IReservationPersistencePort {
    void saveReservation(Reservation reservation);

    void deleteReservation(Long reservationId);

    List<Reservation> getReservation(String identificationNumber);
}
