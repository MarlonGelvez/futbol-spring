package com.futbol.clubes.repository;

import com.futbol.clubes.model.Asociacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociacionRepository extends MongoRepository<Asociacion, String> {
}
