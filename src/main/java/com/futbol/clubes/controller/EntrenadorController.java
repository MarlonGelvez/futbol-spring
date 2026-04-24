package com.futbol.clubes.controller;

import com.futbol.clubes.model.Entrenador;
import com.futbol.clubes.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> obtenerTodos() {
        return entrenadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerPorId(@PathVariable String id) {
        return entrenadorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardar(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable String id, @RequestBody Entrenador entrenador) {
        return entrenadorService.obtenerPorId(id)
                .map(e -> ResponseEntity.ok(entrenadorService.actualizar(id, entrenador)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        return entrenadorService.obtenerPorId(id)
                .map(e -> {
                    entrenadorService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
