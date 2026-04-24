package com.futbol.clubes.controller;

import com.futbol.clubes.model.Club;
import com.futbol.clubes.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubes")
public class ClubController {

    @Autowired
    private ClubService clubService;

    // GET /api/clubes
    @GetMapping
    public List<Club> obtenerTodos() {
        return clubService.obtenerTodos();
    }

    // GET /api/clubes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Club> obtenerPorId(@PathVariable String id) {
        return clubService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/clubes
    @PostMapping
    public Club crear(@RequestBody Club club) {
        return clubService.guardar(club);
    }

    // PUT /api/clubes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Club> actualizar(@PathVariable String id, @RequestBody Club club) {
        return clubService.obtenerPorId(id)
                .map(c -> ResponseEntity.ok(clubService.actualizar(id, club)))
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/clubes/{id}
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
