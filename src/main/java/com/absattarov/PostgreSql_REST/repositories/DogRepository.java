package com.absattarov.PostgreSql_REST.repositories;

import com.absattarov.PostgreSql_REST.model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DogRepository extends MongoRepository<Dog, UUID> {
    Dog findByName(String name);
}
