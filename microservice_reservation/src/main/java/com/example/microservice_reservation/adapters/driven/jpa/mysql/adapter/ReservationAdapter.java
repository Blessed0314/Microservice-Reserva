package com.example.microservice_reservation.adapters.driven.jpa.mysql.adapter;

import com.example.microservice_reservation.adapters.driven.jpa.mysql.mapper.IReservationEntityMapper;
import com.example.microservice_reservation.adapters.driven.jpa.mysql.repository.IReservationRepository;
import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationFlightRequest;
import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationHotelRequest;
import com.example.microservice_reservation.adapters.services.ClientService;
import com.example.microservice_reservation.domain.model.Reservation;
import com.example.microservice_reservation.domain.spi.IReservationPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.scope.ScopedProxyUtils;

@RequiredArgsConstructor
public class ReservationAdapter implements IReservationPersistencePort {

    private  final  IReservationRepository reservationRepository;

    private final IReservationEntityMapper reservationEntityMapper;


    private final ClientService clientService;

    @Override
    public void saveReservation(Reservation reservation) {

        AddReservationFlightRequest addReservationFlightRequest = new AddReservationFlightRequest(reservation.getId_flight(),
                reservation.getAmount_people(), reservation.getNetValue(), reservation.isActive());

        Long idFlight = clientService.addReservationFlight(addReservationFlightRequest);

        AddReservationHotelRequest addReservationHotelRequest = new AddReservationHotelRequest(reservation.getId_hotel(),
                reservation.getAmount_people(),reservation.getAmount_night());

        Long idHotel = clientService.addReservationHotel(addReservationHotelRequest);
        System.out.println("idHotel: "+idHotel);
        System.out.println("idFlight: "+idFlight);




        reservation.setIdReservationFlight(idFlight);

        reservation.setIdReservationHotel(idHotel);

        reservationRepository.save(reservationEntityMapper.toReservationEntity(reservation));

    }
}
