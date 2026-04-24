package com.futbol.clubes.service;

import com.futbol.clubes.model.Entrenador;
import com.futbol.clubes.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> obtenerPorId(String id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador actualizar(String id, Entrenador entrenador) {
        entrenador.setId(id);
        return entrenadorRepository.save(entrenador);
    }

    public void eliminar(String id) {
        entrenadorRepository.deleteById(id);
    }
}
