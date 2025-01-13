package com.taller.PaqueteTuristico.controllers;

import com.taller.PaqueteTuristico.model.entities.PaqueteTuristico;
import com.taller.PaqueteTuristico.services.PaqueteTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paquetes")
@CrossOrigin(origins = "http://localhost:5500")
public class PaqueteTuristicoController {

    @Autowired
    private PaqueteTuristicoService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody PaqueteTuristico paqueteTuristico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paqueteTuristico));
    }

    @GetMapping
    public List<PaqueteTuristico> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<PaqueteTuristico> paqueteOptional = service.findById((long) id);
        if (paqueteOptional.isPresent()) {
            return ResponseEntity.ok().body(paqueteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody PaqueteTuristico paqueteTuristico, @PathVariable int id) {
        Optional<PaqueteTuristico> paqueteOptional = service.findById((long) id);
        if (paqueteOptional.isPresent()) {
            PaqueteTuristico paqueteDB = paqueteOptional.get();
            paqueteDB.setNombre(paqueteTuristico.getNombre());
            paqueteDB.setDescripcion(paqueteTuristico.getDescripcion());
            paqueteDB.setDuracionDias(paqueteTuristico.getDuracionDias());
            paqueteDB.setFechaInicio(paqueteTuristico.getFechaInicio());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paqueteDB));
        }
        return ResponseEntity.notFound().build();
    }
}
