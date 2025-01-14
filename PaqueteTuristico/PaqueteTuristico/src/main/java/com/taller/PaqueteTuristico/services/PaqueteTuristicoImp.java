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

    @Override
    public PaqueteTuristico update(Long id, PaqueteTuristico paquete) {

        Optional<PaqueteTuristico> paqueteOptional = paqueteTuristicoRepository.findById(id);
        if (paqueteOptional.isPresent()) {
            PaqueteTuristico paqueteDB = paqueteOptional.get();

            // Actualizar los campos del paquete con los valores nuevos
            if (paquete.getNombre() != null) {
                paqueteDB.setNombre(paquete.getNombre());
            }
            if (paquete.getDescripcion() != null) {
                paqueteDB.setDescripcion(paquete.getDescripcion());
            }
            if (paquete.getDuracionDias() > 0) {
                paqueteDB.setDuracionDias(paquete.getDuracionDias());
            }
            if (paquete.getFechaInicio() != null) {
                paqueteDB.setFechaInicio(paquete.getFechaInicio());
            }
            return paqueteTuristicoRepository.save(paqueteDB);
        } else {
            throw new RuntimeException("Paquete turístico no encontrado con el ID: " + id);
        }
    }
}
