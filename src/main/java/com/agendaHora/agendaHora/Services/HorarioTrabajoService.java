package com.agendaHora.agendaHora.Services;

import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import com.agendaHora.agendaHora.Models.HorarioTrabajoRequest;
import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Repositories.HorarioTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HorarioTrabajoService {

    @Autowired
    private HorarioTrabajoRepository horarioTrabajoRepository;

    public HorarioTrabajo asignarHorarioTrabajo(Medico medico, String diaSemana, String horaInicio, String horaFin) {
        HorarioTrabajo horarioTrabajo = new HorarioTrabajo();
        horarioTrabajo.setMedico(medico);
        horarioTrabajo.setDiaSemana(diaSemana);
        horarioTrabajo.setHoraInicio(horaInicio);
        horarioTrabajo.setHoraFin(horaFin);

        return horarioTrabajoRepository.save(horarioTrabajo);
    }

    public void borrarHorarioTrabajo(Long horarioId) {
        horarioTrabajoRepository.deleteById(horarioId);
    }

    // En tu servicio (HorarioTrabajoService.java)
    public HorarioTrabajo modificarHora(Long horarioId, HorarioTrabajoRequest horarioTrabajoDto) {
        Optional<HorarioTrabajo> optionalHorarioTrabajo = horarioTrabajoRepository.findById(horarioId);

        if (optionalHorarioTrabajo.isPresent()) {
            HorarioTrabajo horarioTrabajo = optionalHorarioTrabajo.get();
            horarioTrabajo.setDiaSemana(horarioTrabajoDto.getDiaSemana());
            horarioTrabajo.setHoraInicio(horarioTrabajoDto.getHoraInicio());
            horarioTrabajo.setHoraFin(horarioTrabajoDto.getHoraFin());

            return horarioTrabajoRepository.save(horarioTrabajo);
        } else {
            throw new NoSuchElementException("Horario de trabajo no encontrado con ID: " + horarioId);
        }
    }

    public List<HorarioTrabajo> obtenerHorariosPorMedico(Medico medico) {
        return horarioTrabajoRepository.findByMedico(medico);
    }

    // Otros métodos relacionados con los horarios de trabajo
}
