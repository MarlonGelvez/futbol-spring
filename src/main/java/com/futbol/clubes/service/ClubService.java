package com.futbol.clubes.service;

import com.futbol.clubes.model.Club;
import com.futbol.clubes.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public List<Club> obtenerTodos() {
        return clubRepository.findAll();
    }

    public Optional<Club> obtenerPorId(String id) {
        return clubRepository.findById(id);
    }

    public Club guardar(Club club) {
        return clubRepository.save(club);
    }

    public Club actualizar(String id, Club club) {
        club.setId(id);
        return clubRepository.save(club);
    }

    public void eliminar(String id) {
        clubRepository.deleteById(id);
    }
}
