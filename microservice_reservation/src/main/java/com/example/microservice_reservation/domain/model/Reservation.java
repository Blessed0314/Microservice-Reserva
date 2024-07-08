package com.example.microservice_reservation.domain.model;

public class Reservation {

    private final Long id;

    private  Long idReservationHotel;

    private final String name;

    private  String date;



    private final Long id_hotel;

    private  Long idReservationFlight;

    private final Long id_flight;


    private final String startDate;

    private final String endDate;

    private final String identificationNumber;


    public Reservation(Long id, String name, String date, Long id_hotel, Long id_flight, String startDate, String endDate, String identificationNumber, Integer amount_people, Integer amount_night, Float net_price) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.id_hotel = id_hotel;
        this.id_flight = id_flight;
        this.startDate = startDate;
        this.endDate = endDate;
        this.identificationNumber = identificationNumber;
        this.amount_people = amount_people;
        this.amount_night = amount_night;
        this.net_price = net_price;
    }

    public Long getId_hotel() {
        return id_hotel;
    }

    public Long getId_flight() {
        return id_flight;
    }

    public Integer getAmount_people() {
        return amount_people;
    }

    public Integer getAmount_night() {
        return amount_night;
    }

    public Float getNet_price() {
        return net_price;
    }



    private final Integer amount_people;

    private  Integer amount_night;

    public void setAmount_night(Integer amount_night) {
        this.amount_night = amount_night;
    }

    private final Float net_price;

    public void setIdReservationHotel(Long idReservationHotel) {
        this.idReservationHotel = idReservationHotel;
    }

    public void setIdReservationFlight(Long idReservationFlight) {
        this.idReservationFlight = idReservationFlight;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setDate(String date) {
        this.date = date;
    }






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




}
