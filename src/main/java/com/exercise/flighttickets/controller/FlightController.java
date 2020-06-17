package com.exercise.flighttickets.controller;

import com.exercise.flighttickets.model.Flight;
import com.exercise.flighttickets.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createFlight(@RequestBody Flight request) {
        try {
            return ResponseEntity.ok(flightService.save(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getFlight(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(flightService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
