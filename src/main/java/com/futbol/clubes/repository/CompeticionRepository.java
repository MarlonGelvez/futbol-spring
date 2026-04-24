package com.futbol.clubes.repository;

import com.futbol.clubes.model.Competicion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompeticionRepository extends MongoRepository<Competicion, String> {
}
