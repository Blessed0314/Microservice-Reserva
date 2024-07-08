package com.example.microservice_reservation.domain.api;

import com.example.microservice_reservation.domain.model.Reservation;

import java.util.List;

public interface IReservationServicePort {
    void saveReservation(Reservation reservation);

    void deleteReservation(Long reservationId);

    List<Reservation> getReservation(String identificationNumber);
}
