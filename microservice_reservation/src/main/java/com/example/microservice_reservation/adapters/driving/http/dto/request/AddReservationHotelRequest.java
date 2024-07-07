package com.example.microservice_reservation.adapters.driving.http.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddReservationHotelRequest {

    private final Long idHotel;

    private final int people;

    private final int nights;
}
