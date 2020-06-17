package com.exercise.flighttickets.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private String cityOrigin;
    private String cityDestination;
    private String passengerName;
    private int passengerAge;
    private Float price;
    private boolean luggageStorage;
}
