package com.example.microservice_reservation.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddReservationRequest {


    private final Long id_hotel;

    private final Long id_flight;

    private final String identification_number;

    private final String name;

    private final Integer amount_people;


    private final String startDate;

    private final String endDate;





}
