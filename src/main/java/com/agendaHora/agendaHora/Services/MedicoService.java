package com.agendaHora.agendaHora.Services;

import com.agendaHora.agendaHora.Models.DTOs.MedicoDTO;
import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Repositories.HorarioTrabajoRepository;
import com.agendaHora.agendaHora.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private HorarioTrabajoRepository horarioTrabajoRepository;

    @Autowired
    private HorarioTrabajoService horarioTrabajoService;




    public List<MedicoDTO> buscarMedicosPorNombreOApellido(String query) {
        List<Object[]> medicosData = medicoRepository.buscarPorNombreOApellido(query);

        // Mapear los datos a objetos DTO (Data Transfer Object) para la respuesta
        return medicosData.stream()
                .map(data -> new MedicoDTO((Long) data[0], (String) data[1], (String) data[2], (String) data[3]))
                .collect(Collectors.toList());
    }

    public List<Medico> obtenerMedicosPorFechaDeHorario(Date fecha) {
        return medicoRepository.findDistinctByHorariosTrabajoFecha(fecha);
    }


    public List<MedicoDTO> obtenerMedicosPorEspecialidad(Long idEspecialidad) {
        List<Object[]> medicosData = medicoRepository.findMedicosByEspecialidadId(idEspecialidad);

        // Mapear los datos a objetos DTO (Data Transfer Object) para la respuesta
        return medicosData.stream()
                .map(data -> new MedicoDTO((Long) data[0], (String) data[1], (String) data[2], (String) data[3]))
                .collect(Collectors.toList());
    }


    public MedicoDTO obtenerMedicoPorId(Long id) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);

        if (medicoOptional.isPresent()) {
            Medico medico = medicoOptional.get();
            // Mapear entidad Medico a DTO
            return new MedicoDTO(medico.getId(), medico.getNombre(), medico.getApellido(), medico.getEmail());
        } else {
            return new MedicoDTO(null, null, null, null);        }
    }

}