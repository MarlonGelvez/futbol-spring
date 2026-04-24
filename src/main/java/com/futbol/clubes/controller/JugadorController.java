package com.futbol.clubes.controller;

import com.futbol.clubes.model.Jugador;
import com.futbol.clubes.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> obtenerTodos() {
        return jugadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerPorId(@PathVariable String id) {
        return jugadorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable String id, @RequestBody Jugador jugador) {
        return jugadorService.obtenerPorId(id)
                .map(j -> ResponseEntity.ok(jugadorService.actualizar(id, jugador)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        return jugadorService.obtenerPorId(id)
                .map(j -> {
                    jugadorService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
