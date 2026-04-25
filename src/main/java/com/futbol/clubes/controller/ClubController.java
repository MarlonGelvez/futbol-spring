package com.futbol.clubes.controller;

import com.futbol.clubes.model.*;
import com.futbol.clubes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clubes")
public class ClubController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private EntrenadorService entrenadorService;
    @Autowired
    private JugadorService jugadorService;
    @Autowired
    private AsociacionService asociacionService;
    @Autowired
    private CompeticionService competicionService;

    @GetMapping
    public List<Club> obtenerTodos() {
        return clubService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> obtenerPorId(@PathVariable String id) {
        return clubService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ClubRequest req) {
        Club club = new Club();
        club.setNombre(req.getNombre());
        club.setCiudad(req.getCiudad());
        club.setAnioFundacion(req.getAnioFundacion());

        if (req.getEntrenadorId() != null)
            entrenadorService.obtenerPorId(req.getEntrenadorId()).ifPresent(club::setEntrenador);

        if (req.getAsociacionId() != null)
            asociacionService.obtenerPorId(req.getAsociacionId()).ifPresent(club::setAsociacion);

        if (req.getJugadoresIds() != null) {
            List<Jugador> jugadores = req.getJugadoresIds().stream()
                .map(id -> jugadorService.obtenerPorId(id).orElse(null))
                .filter(j -> j != null)
                .collect(Collectors.toList());
            club.setJugadores(jugadores);
        }

        if (req.getCompeticionesIds() != null) {
            List<Competicion> competiciones = req.getCompeticionesIds().stream()
                .map(id -> competicionService.obtenerPorId(id).orElse(null))
                .filter(c -> c != null)
                .collect(Collectors.toList());
            club.setCompeticiones(competiciones);
        }

        return ResponseEntity.ok(clubService.guardar(club));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> actualizar(@PathVariable String id, @RequestBody Club club) {
        return clubService.obtenerPorId(id)
                .map(c -> ResponseEntity.ok(clubService.actualizar(id, club)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        return clubService.obtenerPorId(id)
                .map(c -> {
                    clubService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
