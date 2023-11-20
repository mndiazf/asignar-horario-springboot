package com.agendaHora.agendaHora.Services;

import com.agendaHora.agendaHora.Models.DTOs.HorarioTrabajoDTO;
import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import com.agendaHora.agendaHora.Repositories.HorarioTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioTrabajoService {


    @Autowired
    private HorarioTrabajoRepository horarioTrabajoRepository;

    public List<HorarioTrabajoDTO> obtenerFechasPorMedico(Long medicoId) {
        List<HorarioTrabajo> horarios = horarioTrabajoRepository.findByMedicoId(medicoId);

        return horarios.stream()
                .map(horario -> new HorarioTrabajoDTO(horario.getId(), horario.getFecha()))
                .collect(Collectors.toList());
    }

    public List<String> obtenerHorasPorMedicoIdYFecha(Long idMedico, Date fecha) {
        return horarioTrabajoRepository.findHorasByMedicoIdAndFecha(idMedico, fecha);
    }

}
