package com.example.microservice_reservation.domain.api.usecase;

import com.example.microservice_reservation.domain.api.IReservationServicePort;
import com.example.microservice_reservation.domain.model.Reservation;
import com.example.microservice_reservation.domain.spi.IReservationPersistencePort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReservationUseCase implements IReservationServicePort {

    private final IReservationPersistencePort reservationPersistencePort;

    public ReservationUseCase(IReservationPersistencePort reservationPersistencePort) {
        this.reservationPersistencePort = reservationPersistencePort;
    }

    @Override
    public void saveReservation(Reservation reservation) {

        String date = LocalDate.now().toString();
        reservation.setDate(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(reservation.getStartDate(), formatter);
        LocalDate endDate = LocalDate.parse(reservation.getEndDate(), formatter);

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("The start date must be before the end date");
        }

        long nights = ChronoUnit.DAYS.between(startDate, endDate);
        reservation.setAmount_night((int) nights);

        reservationPersistencePort.saveReservation(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationPersistencePort.deleteReservation(reservationId);
    }


    @Override
    public List<Reservation> getReservation(String identificationNumber) {
        return reservationPersistencePort.getReservation(identificationNumber);
    }
}
