package com.futbol.clubes.service;

import com.futbol.clubes.model.Jugador;
import com.futbol.clubes.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> obtenerPorId(String id) {
        return jugadorRepository.findById(id);
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador actualizar(String id, Jugador jugador) {
        jugador.setId(id);
        return jugadorRepository.save(jugador);
    }

    public void eliminar(String id) {
        jugadorRepository.deleteById(id);
    }
}
