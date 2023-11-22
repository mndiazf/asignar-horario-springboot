package com.agendaHora.agendaHora.Controller;

import com.agendaHora.agendaHora.Models.DTOs.HorarioTrabajoDTO;

import com.agendaHora.agendaHora.Repositories.HorarioTrabajoRepository;
import com.agendaHora.agendaHora.Services.HorarioTrabajoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/horarios-trabajo")
public class HorarioTrabajoController {

    @Autowired
    private HorarioTrabajoRepository horarioTrabajoRepository;

    @Autowired
    private  HorarioTrabajoService horarioTrabajoService;


    //CRUD
    //Generar horario de trabajo
    @PostMapping("/generarHorario")
    public ResponseEntity<?> generarHorarioTrabajo(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
            @RequestParam Long idMedico) {
        return horarioTrabajoService.generarHorarioTrabajo(fecha, idMedico);
    }
    // Modificar horario de trabajo
    @PutMapping("/modificarHorario/{idHorarioTrabajo}")
    public ResponseEntity<?> modificarFechaHorarioTrabajo(
            @PathVariable Long idHorarioTrabajo,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date nuevaFecha) {
        return horarioTrabajoService.modificarFechaHorarioTrabajo(idHorarioTrabajo, nuevaFecha);
    }


    //Guardar hora segun id_horariotrabajo
    @PostMapping("/guardarHora")
    public ResponseEntity<?> guardarHora(
            @RequestParam String hora,
            @RequestParam Long idHorarioTrabajo) {
        return horarioTrabajoService.guardarHora(hora, idHorarioTrabajo);
    }

    //Modificar Hora
    @PutMapping("/modificarHora/{idHora}")
    public ResponseEntity<?> modificarHora(
            @PathVariable Long idHora,
            @RequestParam String nuevaHora) {
        return horarioTrabajoService.modificarHora(idHora, nuevaHora);
    }


    //Borrar Horario de trabajo junto con todas sus horas
    @Transactional
    @DeleteMapping("/borrarHorario/{idHorarioTrabajo}")
    public ResponseEntity<?> borrarHorarioTrabajo(@PathVariable Long idHorarioTrabajo) {
        return horarioTrabajoService.borrarHorarioTrabajo(idHorarioTrabajo);
    }

    //Borrar hora
    @DeleteMapping("/borrarHora/{idHora}")
    public ResponseEntity<?> borrarHora(@PathVariable Long idHora) {
        return horarioTrabajoService.borrarHora(idHora);
    }



    //Obtener fechas por id de medico
    @GetMapping("/fechas/{medicoId}")
    public ResponseEntity<List<HorarioTrabajoDTO>> obtenerFechasPorMedico(@PathVariable Long medicoId) {
        List<HorarioTrabajoDTO> horariosDTO = horarioTrabajoService.obtenerFechasPorMedico(medicoId);
        return ResponseEntity.ok().body(horariosDTO);
    }

    //Obtener horas por id de horario trabajo
    @GetMapping("/horas/{idHorarioTrabajo}")
    public ResponseEntity<List<String>> obtenerHorasPorHorarioTrabajoId(@PathVariable Long idHorarioTrabajo) {
        List<String> horas = horarioTrabajoService.obtenerHorasPorHorarioTrabajoId(idHorarioTrabajo);

        if (horas != null && !horas.isEmpty()) {
            return ResponseEntity.ok().body(horas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
