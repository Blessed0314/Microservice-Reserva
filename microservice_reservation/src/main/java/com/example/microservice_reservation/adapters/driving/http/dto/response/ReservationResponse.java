package com.example.microservice_reservation.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReservationResponse {
    private final Long id;

    private  Long idReservationHotel;

    private  Long idReservationFlight;

    private final String identificationNumber;

    private Boolean active;

}
