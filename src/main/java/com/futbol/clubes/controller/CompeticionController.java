package com.futbol.clubes.controller;

import com.futbol.clubes.model.Competicion;
import com.futbol.clubes.service.CompeticionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionService competicionService;

    @GetMapping
    public List<Competicion> obtenerTodos() {
        return competicionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competicion> obtenerPorId(@PathVariable String id) {
        return competicionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competicion crear(@RequestBody Competicion competicion) {
        return competicionService.guardar(competicion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competicion> actualizar(@PathVariable String id, @RequestBody Competicion competicion) {
        return competicionService.obtenerPorId(id)
                .map(c -> ResponseEntity.ok(competicionService.actualizar(id, competicion)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        return competicionService.obtenerPorId(id)
                .map(c -> {
                    competicionService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
