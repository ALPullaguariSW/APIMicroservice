package com.taller.PaqueteTuristico.services;

import com.taller.PaqueteTuristico.model.entities.PaqueteTuristico;
import com.taller.PaqueteTuristico.repositories.PaqueteTuristicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PaqueteTuristicoImp implements PaqueteTuristicoService {
    @Autowired
    private PaqueteTuristicoRepository paqueteTuristicoRepository;
    @Override
    public List<PaqueteTuristico> findAll() {
        return (List<PaqueteTuristico>) paqueteTuristicoRepository.findAll();
    }

    @Override
    public PaqueteTuristico save(PaqueteTuristico paquete) {
        return paqueteTuristicoRepository.save(paquete);
    }
    @Override
    public Optional<PaqueteTuristico> findById(Long id) {
        return paqueteTuristicoRepository.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        paqueteTuristicoRepository.deleteById(id);
    }
}
