package com.example.microservice_reservation.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddReservationFlightRequest {
    private final Long idFlight;

    private final int people;
    private final int netValue;
    private final boolean isActive;

}
