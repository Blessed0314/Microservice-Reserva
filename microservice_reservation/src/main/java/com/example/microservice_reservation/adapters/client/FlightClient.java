package com.example.microservice_reservation.adapters.client;

import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationFlightRequest;
import com.example.microservice_reservation.configuration.client.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "flight-service", url = "http://localhost:8090", configuration = FeignClientConfig.class)
public interface FlightClient {

    @PostMapping("/reservation/")
    Long addReservation(@RequestBody AddReservationFlightRequest request);

}
