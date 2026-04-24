package com.futbol.clubes.controller;

import com.futbol.clubes.model.Asociacion;
import com.futbol.clubes.service.AsociacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionService asociacionService;

    @GetMapping
    public List<Asociacion> obtenerTodos() {
        return asociacionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asociacion> obtenerPorId(@PathVariable String id) {
        return asociacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asociacion crear(@RequestBody Asociacion asociacion) {
        return asociacionService.guardar(asociacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asociacion> actualizar(@PathVariable String id, @RequestBody Asociacion asociacion) {
        return asociacionService.obtenerPorId(id)
                .map(a -> ResponseEntity.ok(asociacionService.actualizar(id, asociacion)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        return asociacionService.obtenerPorId(id)
                .map(a -> {
                    asociacionService.eliminar(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
