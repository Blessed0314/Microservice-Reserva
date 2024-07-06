package com.example.microservice_reservation.configuration;

import com.example.microservice_reservation.adapters.driven.jpa.mysql.adapter.ReservationAdapter;
import com.example.microservice_reservation.adapters.driven.jpa.mysql.mapper.IReservationEntityMapper;
import com.example.microservice_reservation.adapters.driven.jpa.mysql.repository.IReservationRepository;
import com.example.microservice_reservation.domain.api.IReservationServicePort;
import com.example.microservice_reservation.domain.api.usecase.ReservationUseCase;
import com.example.microservice_reservation.domain.spi.IReservationPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IReservationRepository reservationRepository;

    private final IReservationEntityMapper reservationEntityMapper;

    @Bean
    public IReservationPersistencePort reservationsPersistencePort() {
        return new ReservationAdapter(reservationRepository, reservationEntityMapper);
    }

    @Bean
    public IReservationServicePort reservationServicePort(){
        return new ReservationUseCase(reservationsPersistencePort());
    }
}
