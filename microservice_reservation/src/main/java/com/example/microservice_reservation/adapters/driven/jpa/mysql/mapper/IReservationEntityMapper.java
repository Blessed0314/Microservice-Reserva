package com.example.microservice_reservation.adapters.driven.jpa.mysql.mapper;

import com.example.microservice_reservation.adapters.driven.jpa.mysql.entity.ReservationEntity;
import com.example.microservice_reservation.domain.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IReservationEntityMapper {
    @Mapping(target = "id_reservation_hotel", source = "idReservationHotel")
    @Mapping(target = "id_reservation_flight", source = "idReservationFlight")
    @Mapping(target = "identification_number", source = "identificationNumber")
    ReservationEntity toReservationEntity(Reservation reservation);
    @Mapping(target = "idReservationHotel", ignore = true)
    @Mapping(target = "idReservationFlight", ignore = true)
    Reservation toReservation(ReservationEntity reservationEntity);
}
