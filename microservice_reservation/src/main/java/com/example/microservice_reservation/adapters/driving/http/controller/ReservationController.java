package com.example.microservice_reservation.adapters.driving.http.controller;

import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationRequest;
import com.example.microservice_reservation.adapters.driving.http.mapper.IReservationRequestMapper;
import com.example.microservice_reservation.domain.api.IReservationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationServicePort reservationService;

    private final IReservationRequestMapper reservationRequestMapper;

    @PostMapping("/add")
    public ResponseEntity<Void> addReservation(AddReservationRequest addReservationRequest) {
        reservationService.saveReservation(reservationRequestMapper.toReservation(addReservationRequest));
        return ResponseEntity.ok().build();
    }
}
