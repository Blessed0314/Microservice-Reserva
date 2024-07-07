package com.example.microservice_reservation.adapters.client;

import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationHotelRequest;
import com.example.microservice_reservation.configuration.client.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "hotel-service", url = "http://localhost:8092", configuration = FeignClientConfig.class)
public interface HotelClient {
    @PostMapping("/reservation/")
    Long addReservationHotel(AddReservationHotelRequest request);
}
