package com.exercise.flighttickets.repository;

import com.exercise.flighttickets.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends CrudRepository<Flight, UUID> {
}
