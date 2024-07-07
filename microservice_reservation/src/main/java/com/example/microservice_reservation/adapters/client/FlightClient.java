package com.example.microservice_reservation.adapters.client;

import com.example.microservice_reservation.configuration.client.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "flight-service", url = "http://localhost:8092", configuration = FeignClientConfig.class)
public interface FlightClient {
}
