package com.example.microservice_reservation.adapters.services;

import com.example.microservice_reservation.adapters.client.FlightClient;
import com.example.microservice_reservation.adapters.client.HotelClient;
import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationFlightRequest;
import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationHotelRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final HotelClient hotelClient;

    private final FlightClient flightClient;

    public ClientService(HotelClient hotelClient, FlightClient flightClient) {
        this.hotelClient = hotelClient;
        this.flightClient = flightClient;
    }

    public Long addReservationHotel(AddReservationHotelRequest request) {
        return hotelClient.addReservationHotel(request);
    }

    public Long addReservationFlight(AddReservationFlightRequest request) {
        return flightClient.addReservation(request);
    }
}
