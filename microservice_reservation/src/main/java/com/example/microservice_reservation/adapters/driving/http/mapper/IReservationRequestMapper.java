package com.example.microservice_reservation.adapters.driving.http.mapper;

import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationRequest;
import com.example.microservice_reservation.domain.model.Reservation;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IReservationRequestMapper {

    @Mapping(target = "id", ignore = true)
    Reservation toReservation(AddReservationRequest addReservationRequest);
}
