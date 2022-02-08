package org.iesfm.service;

import org.iesfm.repository.PassengerRepository;
import org.iesfm.service.exceptions.PassengerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojos.Bagagge;
import pojos.Passenger;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public boolean RegisterPassenger (Passenger passenger) {
        if (passengerRepository.findByPassengerId(passenger.getPassengerId()) != null) {
            return false;
        } else {
            passengerRepository.insert(passenger);
            return true;
        }
    }

    public List<Passenger> listFlightPassengers(Integer flightNumber) {
        List<Passenger> passengers = passengerRepository.findAll();
        List<Passenger> flightPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getPassengerId().getFlightNumber().equals(flightNumber)) {
                flightPassengers.add(passenger);
            }
        }
        return flightPassengers;
    }



    public boolean addBagagge (Passenger.CompositeKey passengerId, Bagagge bag) throws PassengerNotFoundException {
        Passenger passenger = passengerRepository.findByPassengerId(passengerId);
        if (passenger != null) {
            List<Bagagge> bagagge = passenger.getBaggage();
            if (!bagagge.contains(bag)) {
                passengerRepository.deleteById(passengerId);
                bagagge.add(bag);
                passenger.setBaggage(bagagge);
                passengerRepository.insert(passenger);
                return true;
            } else {
                return false;
            }
        } else {
            throw new PassengerNotFoundException();
        }
    }

    public List<Bagagge> listBagagge (Passenger.CompositeKey passengerId) {
        return passengerRepository.findByPassengerId(passengerId).getBaggage();
    }
}
