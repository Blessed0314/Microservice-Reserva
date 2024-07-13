package com.example.microservice_reservation.adapters.driving.http.mapper;

import com.example.microservice_reservation.adapters.driving.http.dto.response.ReservationResponse;
import com.example.microservice_reservation.domain.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReservationResponseMapper {
    @Mapping(target = "active", source = "active")
    List<ReservationResponse> toReservationResponse(List<Reservation> reservation);
}
