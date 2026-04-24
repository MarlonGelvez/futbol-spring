package com.futbol.clubes.service;

import com.futbol.clubes.model.Competicion;
import com.futbol.clubes.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompeticionService {

    @Autowired
    private CompeticionRepository competicionRepository;

    public List<Competicion> obtenerTodos() {
        return competicionRepository.findAll();
    }

    public Optional<Competicion> obtenerPorId(String id) {
        return competicionRepository.findById(id);
    }

    public Competicion guardar(Competicion competicion) {
        return competicionRepository.save(competicion);
    }

    public Competicion actualizar(String id, Competicion competicion) {
        competicion.setId(id);
        return competicionRepository.save(competicion);
    }

    public void eliminar(String id) {
        competicionRepository.deleteById(id);
    }
}
