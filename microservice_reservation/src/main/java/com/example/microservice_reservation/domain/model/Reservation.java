package com.example.microservice_reservation.domain.model;

public class Reservation {

    private final Long id;

    private final Long idReservationHotel;

    private final String name;

    private final String date;

    private final Long id_hotel;

    private final Long id_flight;

    public Long getId_hotel() {
        return id_hotel;
    }

    public Long getId_flight() {
        return id_flight;
    }

    public Integer getAmount_people() {
        return amount_people;
    }

    public String getAmount_night() {
        return amount_night;
    }

    public Float getNet_price() {
        return net_price;
    }

    public boolean isStatus() {
        return status;
    }

    private final Integer amount_people;

    private final String amount_night;

    public Reservation(Long id, Long idReservationHotel, String name, String date, Long id_hotel, Long id_flight, Integer amount_people, String amount_night, Float net_price, boolean status, Long idReservationFlight, String identificationNumber) {
        this.id = id;
        this.idReservationHotel = idReservationHotel;
        this.name = name;
        this.date = date;
        this.id_hotel = id_hotel;
        this.id_flight = id_flight;
        this.amount_people = amount_people;
        this.amount_night = amount_night;
        this.net_price = net_price;
        this.status = status;
        this.idReservationFlight = idReservationFlight;
        this.identificationNumber = identificationNumber;
    }

    private final Float net_price;

    private final boolean status;



    private final Long idReservationFlight;

    public Long getId() {
        return id;
    }

    public Long getIdReservationHotel() {
        return idReservationHotel;
    }

    public Long getIdReservationFlight() {
        return idReservationFlight;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    private final String identificationNumber;



}
