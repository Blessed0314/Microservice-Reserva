package com.example.microservice_reservation.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long id_reservation_hotel;

    @Column
    private Long id_reservation_flight;

    @Column
    private String identification_number;

    @Column
    private String name;

    @Column
    private String date;
}
