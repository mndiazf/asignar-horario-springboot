package com.agendaHora.agendaHora.Services;

import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico obtenerMedicoPorId(Long medicoId) {
        Optional<Medico> optionalMedico = medicoRepository.findById(medicoId);

        if (optionalMedico.isPresent()) {
            return optionalMedico.get();
        } else {
            throw new NoSuchElementException("Médico no encontrado con ID: " + medicoId);
        }
    }

    // Otros métodos relacionados con los médicos
}