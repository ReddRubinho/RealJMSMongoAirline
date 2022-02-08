package org.iesfm.service;

import org.iesfm.repository.FlighRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojos.Flight;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlighRepository flighRepository;

    public boolean insertFlight (Flight flight) {
        if (flighRepository.existsById(flight.getFlightNumber())) {
            return false;
        } else  {
            flighRepository.insert(flight);
            return true;
        }
    }

    public List<Flight> list() {
        return flighRepository.findAll();
    }
}
