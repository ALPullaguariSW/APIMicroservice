package com.taller.PaqueteTuristico.services;



import com.taller.PaqueteTuristico.model.entities.PaqueteTuristico;

import java.util.List;
import java.util.Optional;

public interface PaqueteTuristicoService {
    List<PaqueteTuristico> findAll();
    PaqueteTuristico save(PaqueteTuristico paquete);
    Optional<PaqueteTuristico> findById(Long id);
    void deleteById(Long id);
}
