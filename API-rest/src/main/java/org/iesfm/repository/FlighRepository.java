package org.iesfm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pojos.Flight;

@Repository
public interface FlighRepository extends MongoRepository<Flight, Integer> {
}
