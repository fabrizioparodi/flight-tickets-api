package com.exercise.flighttickets.service;

import com.exercise.flighttickets.model.Flight;
import com.exercise.flighttickets.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight getById(UUID id) {
        return this.flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Itinerary does not exist"));
    }

    public Flight save(Flight flight) {
        return this.flightRepository.save(flight);
    }
}
