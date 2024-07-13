package com.example.microservice_reservation.adapters.driving.http.controller;

import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationRequest;
import com.example.microservice_reservation.adapters.driving.http.dto.response.ReservationResponse;
import com.example.microservice_reservation.adapters.driving.http.mapper.IReservationRequestMapper;
import com.example.microservice_reservation.adapters.driving.http.mapper.IReservationResponseMapper;
import com.example.microservice_reservation.domain.api.IReservationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationServicePort reservationService;

    private final IReservationRequestMapper reservationRequestMapper;

    private final IReservationResponseMapper reservationResponseMapper;

    @PostMapping("/add")
    public ResponseEntity<Void> addReservation(@RequestBody  AddReservationRequest addReservationRequest) {
        reservationService.saveReservation(reservationRequestMapper.toReservation(addReservationRequest));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{identificationNumber}")
    public ResponseEntity<List<ReservationResponse>> getReservationById(@PathVariable String identificationNumber) {
        return ResponseEntity.ok(
                reservationResponseMapper.toReservationResponse(reservationService.getReservation(identificationNumber)));
    }

}
