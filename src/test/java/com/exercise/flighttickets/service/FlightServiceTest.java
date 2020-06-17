package com.exercise.flighttickets.service;

import com.exercise.flighttickets.model.Flight;
import com.exercise.flighttickets.repository.FlightRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class FlightServiceTest {
    private final FlightRepository flightRepository;
    private final FlightService flightService;

    public FlightServiceTest() {
        this.flightRepository = mock(FlightRepository.class);
        this.flightService = new FlightServiceImpl(flightRepository);
    }

    @Test
    public void testCreation_WhenTryToSaveBasicFlight_ThenShouldSucceed() {
        try {
            Flight flightToSave = new Flight();
            flightToSave.setPassengerName("TEST USER");
            when(this.flightRepository.save(any(Flight.class))).thenReturn(flightToSave);

            Flight savedFlight = this.flightService.save(flightToSave);

            Assertions.assertNotNull(savedFlight);
            Assertions.assertEquals(flightToSave.getPassengerName(), savedFlight.getPassengerName());
            verify(this.flightRepository).save(any(Flight.class));
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testFindById_WhenFlightExists_ThenShouldSucceed() {
        try {
            Flight flightToRetrieve = new Flight();
            flightToRetrieve.setId(UUID.randomUUID());
            when(this.flightRepository.findById(flightToRetrieve.getId())).thenReturn(Optional.of(flightToRetrieve));

            Flight retrievedFlight = this.flightService.getById(flightToRetrieve.getId());

            Assertions.assertNotNull(retrievedFlight);
            Assertions.assertEquals(flightToRetrieve.getId(), retrievedFlight.getId());
            verify(this.flightRepository).findById(flightToRetrieve.getId());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testFindById_WhenFlightNotExists_ThenShouldFail() {
        try {
            when(this.flightRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

            Flight flight = this.flightService.getById(UUID.randomUUID());

            Assertions.assertNotNull(flight);
            verify(this.flightRepository).findById(any(UUID.class));

            Assertions.fail("Test should failed");
        } catch (Exception e) {
            Assertions.assertEquals("Itinerary does not exist", e.getMessage());
        }
    }
}
