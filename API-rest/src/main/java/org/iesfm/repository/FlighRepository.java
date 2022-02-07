package org.iesfm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pojos.Flight;

public interface FlighRepository extends MongoRepository<Flight, Integer> {
}
