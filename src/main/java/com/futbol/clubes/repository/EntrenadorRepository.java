package com.futbol.clubes.repository;

import com.futbol.clubes.model.Entrenador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends MongoRepository<Entrenador, String> {
}
