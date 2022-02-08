package org.iesfm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pojos.Passenger;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, Passenger.CompositeKey> {

    Passenger findByPassengerId(Passenger.CompositeKey passengerId);
}
