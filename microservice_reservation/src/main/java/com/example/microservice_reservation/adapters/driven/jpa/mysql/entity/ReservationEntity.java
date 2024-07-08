package com.example.microservice_reservation.adapters.driven.jpa.mysql.entity;


import lombok.*;

import javax.persistence.*;

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
    private String identificationNumber;

    @Column
    private String name;

    @Column
    private String date;
}
