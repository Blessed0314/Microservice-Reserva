package com.example.microservice_reservation.adapters.driven.jpa.mysql.adapter;

import com.example.microservice_reservation.adapters.driven.jpa.mysql.entity.ReservationEntity;
import com.example.microservice_reservation.adapters.driven.jpa.mysql.mapper.IReservationEntityMapper;
import com.example.microservice_reservation.adapters.driven.jpa.mysql.repository.IReservationRepository;
import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationFlightRequest;
import com.example.microservice_reservation.adapters.driving.http.dto.request.AddReservationHotelRequest;
import com.example.microservice_reservation.adapters.services.ClientService;
import com.example.microservice_reservation.domain.model.Reservation;
import com.example.microservice_reservation.domain.spi.IReservationPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.List;

@RequiredArgsConstructor
public class ReservationAdapter implements IReservationPersistencePort {

    private  final  IReservationRepository reservationRepository;

    private final IReservationEntityMapper reservationEntityMapper;


    private final ClientService clientService;

    @Override
    public void saveReservation(Reservation reservation) {

        System.out.println("reservation = " + reservation.getId_flight());

        if (reservation.getId_flight()!=null){
            AddReservationFlightRequest addReservationFlightRequest = new AddReservationFlightRequest(reservation.getId_flight(),
                    reservation.getAmount_people());

            Long idFlight = clientService.addReservationFlight(addReservationFlightRequest);
            reservation.setIdReservationFlight(idFlight);
        }

        if (reservation.getId_hotel()!=null){
            AddReservationHotelRequest addReservationHotelRequest = new AddReservationHotelRequest(reservation.getId_hotel(),
                    reservation.getAmount_people(),reservation.getAmount_night());

            Long idHotel = clientService.addReservationHotel(addReservationHotelRequest);
            reservation.setIdReservationHotel(idHotel);
        }

        reservation.setActive(true);

        reservationRepository.save(reservationEntityMapper.toReservationEntity(reservation));

    }

    @Override
    public void deleteReservation(Long id) {
        ReservationEntity reservation = reservationRepository.findById(id).get();

        System.out.println("reservation.getId_reservation_flight() = " + reservation.getId_reservation_flight());

        if (reservation.getId_reservation_flight()!=null){
            clientService.deleteReservationFlight(reservation.getId_reservation_flight());
        }
        if (reservation.getId_reservation_hotel()!=null){
            clientService.deleteReservationHotel(reservation.getId_reservation_hotel());
        }
        reservation.setActive(false);

        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservation(String identificationNumber) {

        List<ReservationEntity> reservationEntity = reservationRepository.findByIdentificationNumber(identificationNumber);
        return reservationEntityMapper.toReservationList(reservationEntity);

    }
}
