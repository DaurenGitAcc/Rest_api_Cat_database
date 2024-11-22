package com.absattarov.PostgreSql_REST.repositories;

import com.absattarov.PostgreSql_REST.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {
}
