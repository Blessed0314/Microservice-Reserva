package com.example.microservice_reservation.adapters.driven.jpa.mysql.mapper;

import com.example.microservice_reservation.adapters.driven.jpa.mysql.entity.ReservationEntity;
import com.example.microservice_reservation.domain.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReservationEntityMapper {
    @Mapping(target = "id_reservation_hotel", source = "idReservationHotel")
    @Mapping(target = "id_reservation_flight", source = "idReservationFlight")
    //@Mapping(target = "identification_number", source = "identificationNumber")
    ReservationEntity toReservationEntity(Reservation reservation);

    @Mapping(target = "idReservationHotel", source = "id_reservation_hotel")
    @Mapping(target = "idReservationFlight", source = "id_reservation_flight")
    Reservation toReservation(ReservationEntity reservationEntity);


    List<Reservation> toReservation(List<ReservationEntity> reservationEntity);
}
