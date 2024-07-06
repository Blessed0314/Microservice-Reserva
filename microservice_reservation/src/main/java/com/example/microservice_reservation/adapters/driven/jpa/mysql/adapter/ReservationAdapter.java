package com.example.microservice_reservation.adapters.driven.jpa.mysql.adapter;

import com.example.microservice_reservation.adapters.driven.jpa.mysql.mapper.IReservationEntityMapper;
import com.example.microservice_reservation.adapters.driven.jpa.mysql.repository.IReservationRepository;
import com.example.microservice_reservation.domain.model.Reservation;
import com.example.microservice_reservation.domain.spi.IReservationPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReservationAdapter implements IReservationPersistencePort {

    private  final  IReservationRepository reservationRepository;

    private final IReservationEntityMapper reservationEntityMapper;

    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservationEntityMapper.toReservationEntity(reservation));
    }
}
