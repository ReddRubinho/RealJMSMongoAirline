package org.iesfm.controller;

import org.iesfm.controller.pojos.FlightApi;
import org.iesfm.service.FlightService;
import org.springframework.web.bind.annotation.RestController;
import pojos.Flight;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FlightController {

    private FlightService flightService;

    public PassengerController(FlightService flightService) {
        this.flightService = flightService;
    }

    public FlightApi convertToApi(Flight flight) {
        return new FlightApi(
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDeparture()
        );
    }

    public Flight convertToModel(FlightApi flight) {
        return new Flight(
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDeparture()
        );
    }

    public List<Flight> convertToModel(List<FlightApi> flights) {
        return flights.stream().map(flight -> convertToModel(flight)).collect(Collectors.toList());
    }

    public List<FlightApi> convertToApi(List<Flight> flights) {
        return flights.stream().map(flight -> convertToApi(flight)).collect(Collectors.toList());
    }
}
