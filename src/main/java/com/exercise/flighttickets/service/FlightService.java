package com.exercise.flighttickets.service;

import com.exercise.flighttickets.model.Flight;

import java.util.UUID;

public interface FlightService {
    Flight getById(UUID id);

    Flight save(Flight flight);
}
