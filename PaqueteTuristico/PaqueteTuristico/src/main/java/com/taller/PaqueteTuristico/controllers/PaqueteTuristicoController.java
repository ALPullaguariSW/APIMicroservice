package com.taller.PaqueteTuristico.controllers;

import com.taller.PaqueteTuristico.model.entities.PaqueteTuristico;
import com.taller.PaqueteTuristico.services.PaqueteTuristicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/paquetes")
public class PaqueteTuristicoController {

    @Autowired
    PaqueteTuristicoService service;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody PaqueteTuristico paqueteTuristico, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paqueteTuristico));
    }

    @GetMapping
    public List<PaqueteTuristico> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<PaqueteTuristico> paqueteOptional = service.findById(id);
        if (paqueteOptional.isPresent()) {
            return ResponseEntity.ok().body(paqueteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PaqueteTuristico paqueteTuristico, @PathVariable Long id, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            PaqueteTuristico updatedPaquete = service.update(id, paqueteTuristico);
            return ResponseEntity.ok(updatedPaquete);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
