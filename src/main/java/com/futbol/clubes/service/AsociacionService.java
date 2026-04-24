package com.futbol.clubes.service;

import com.futbol.clubes.model.Asociacion;
import com.futbol.clubes.repository.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsociacionService {

    @Autowired
    private AsociacionRepository asociacionRepository;

    public List<Asociacion> obtenerTodos() {
        return asociacionRepository.findAll();
    }

    public Optional<Asociacion> obtenerPorId(String id) {
        return asociacionRepository.findById(id);
    }

    public Asociacion guardar(Asociacion asociacion) {
        return asociacionRepository.save(asociacion);
    }

    public Asociacion actualizar(String id, Asociacion asociacion) {
        asociacion.setId(id);
        return asociacionRepository.save(asociacion);
    }

    public void eliminar(String id) {
        asociacionRepository.deleteById(id);
    }
}
