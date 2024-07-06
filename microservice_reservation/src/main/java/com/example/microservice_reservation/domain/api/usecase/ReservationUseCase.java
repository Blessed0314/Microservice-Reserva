package com.example.microservice_reservation.domain.api.usecase;

import com.example.microservice_reservation.domain.api.IReservationServicePort;
import com.example.microservice_reservation.domain.model.Reservation;
import com.example.microservice_reservation.domain.spi.IReservationPersistencePort;

public class ReservationUseCase implements IReservationServicePort {

    private final IReservationPersistencePort reservationPersistencePort;

    public ReservationUseCase(IReservationPersistencePort reservationPersistencePort) {
        this.reservationPersistencePort = reservationPersistencePort;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationPersistencePort.saveReservation(reservation);
    }
}
