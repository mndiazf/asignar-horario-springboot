package com.agendaHora.agendaHora.Services;

import com.agendaHora.agendaHora.Models.DTOs.HoraDTO;
import com.agendaHora.agendaHora.Models.DTOs.HorarioTrabajoDTO;
import com.agendaHora.agendaHora.Models.Hora;
import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Repositories.HoraRepository;
import com.agendaHora.agendaHora.Repositories.HorarioTrabajoRepository;
import com.agendaHora.agendaHora.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HorarioTrabajoService {



    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private HorarioTrabajoRepository horarioTrabajoRepository;

    @Autowired
    private HoraRepository horaRepository;

    public ResponseEntity<?> generarHorarioTrabajo(Date fecha, Long idMedico) {
        if (horarioTrabajoRepository.existsByFechaAndMedico_Id(fecha, idMedico)) {
            return ResponseEntity.badRequest().body("Ya existe un horario de trabajo para la fecha y el médico proporcionados.");
        }

        HorarioTrabajo nuevoHorario = new HorarioTrabajo();
        nuevoHorario.setFecha(fecha);

        Optional<Medico> optionalMedico = medicoRepository.findById(idMedico);
        if (optionalMedico.isPresent()) {
            nuevoHorario.setMedico(optionalMedico.get());
            horarioTrabajoRepository.save(nuevoHorario);
            return ResponseEntity.ok().body("Horario de trabajo generado exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("No se encontró al médico con el ID proporcionado.");
        }
    }

    public ResponseEntity<?> modificarFechaHorarioTrabajo(Long idHorarioTrabajo, Date nuevaFecha) {
        Optional<HorarioTrabajo> optionalHorarioTrabajo = horarioTrabajoRepository.findById(idHorarioTrabajo);

        if (optionalHorarioTrabajo.isPresent()) {
            HorarioTrabajo horarioTrabajo = optionalHorarioTrabajo.get();

            // Verificar si la nueva fecha es diferente a la fecha actual
            if (!horarioTrabajo.getFecha().equals(nuevaFecha)) {
                horarioTrabajo.setFecha(nuevaFecha);
                horarioTrabajoRepository.save(horarioTrabajo);

                return ResponseEntity.ok().body("Fecha del horario de trabajo modificada exitosamente.");
            } else {
                return ResponseEntity.badRequest().body("La nueva fecha es idéntica a la fecha actual del horario de trabajo.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> guardarHora(String hora, Long idHorarioTrabajo) {
        Optional<HorarioTrabajo> horarioTrabajoOptional = horarioTrabajoRepository.findById(idHorarioTrabajo);

        if (horarioTrabajoOptional.isPresent()) {
            HorarioTrabajo horarioTrabajo = horarioTrabajoOptional.get();

            // Verificar si ya existe la hora para este horario de trabajo
            if (!horaRepository.existsByHoraAndHorarioTrabajo(hora, horarioTrabajo)) {
                // Si no existe, guardar la hora
                Hora nuevaHora = new Hora();
                nuevaHora.setHora(hora);
                nuevaHora.setHorarioTrabajo(horarioTrabajo);
                horaRepository.save(nuevaHora);

                return ResponseEntity.ok().body("Hora guardada exitosamente.");
            } else {
                return ResponseEntity.badRequest().body("Ya existe una hora para este horario de trabajo en esa fecha.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> modificarHora(Long idHora, String nuevaHora) {
        Optional<Hora> horaOptional = horaRepository.findById(idHora);

        if (horaOptional.isPresent()) {
            Hora hora = horaOptional.get();
            HorarioTrabajo horarioTrabajo = hora.getHorarioTrabajo();

            // Verificar si la nueva hora ya existe para este horario de trabajo
            if (!horaRepository.existsByHoraAndHorarioTrabajo(nuevaHora, horarioTrabajo)) {
                // Si no existe, actualizar la hora
                hora.setHora(nuevaHora);
                horaRepository.save(hora);

                return ResponseEntity.ok().body("Hora modificada exitosamente.");
            } else {
                return ResponseEntity.badRequest().body("Ya existe una hora para este horario de trabajo en esa fecha.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<?> borrarHorarioTrabajo(Long idHorarioTrabajo) {
        Optional<HorarioTrabajo> horarioTrabajoOptional = horarioTrabajoRepository.findById(idHorarioTrabajo);

        if (horarioTrabajoOptional.isPresent()) {
            HorarioTrabajo horarioTrabajo = horarioTrabajoOptional.get();

            // Borrar todas las horas asociadas al horarioTrabajo
            horaRepository.deleteByHorarioTrabajo(horarioTrabajo);

            // Borrar el horarioTrabajo
            horarioTrabajoRepository.delete(horarioTrabajo);

            return ResponseEntity.ok().body("Horario de trabajo y horas asociadas borradas exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> borrarHora(Long idHora) {
        Optional<Hora> horaOptional = horaRepository.findById(idHora);

        if (horaOptional.isPresent()) {
            Hora hora = horaOptional.get();
            horaRepository.delete(hora);

            return ResponseEntity.ok().body("Hora borrada exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<HorarioTrabajoDTO> obtenerFechasPorMedico(Long medicoId) {
        List<HorarioTrabajo> horarios = horarioTrabajoRepository.findByMedicoId(medicoId);

        return horarios.stream()
                .map(horario -> new HorarioTrabajoDTO(horario.getId(), horario.getFecha()))
                .collect(Collectors.toList());
    }

    public List<HoraDTO> obtenerHorasPorHorarioTrabajoId(Long idHorarioTrabajo) {
        Optional<HorarioTrabajo> horarioOptional = horarioTrabajoRepository.findById(idHorarioTrabajo);

        return horarioOptional.map(horarioTrabajo ->
                        horarioTrabajo.getHoras().stream()
                                .map(hora -> new HoraDTO(hora.getId(), hora.getHora()))
                                .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }



}
