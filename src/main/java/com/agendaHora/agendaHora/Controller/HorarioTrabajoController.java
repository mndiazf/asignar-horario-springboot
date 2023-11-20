package com.agendaHora.agendaHora.Controller;

import com.agendaHora.agendaHora.Models.DTOs.HorarioTrabajoDTO;
import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Repositories.HorarioTrabajoRepository;
import com.agendaHora.agendaHora.Services.HorarioTrabajoService;
import com.agendaHora.agendaHora.Services.MedicoService;
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

    @GetMapping("/horas-por-medico-y-fecha/{idMedico}")
    public ResponseEntity<List<String>> obtenerHorasPorMedicoIdYFecha(
            @PathVariable("idMedico") Long idMedico,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        List<String> horas = horarioTrabajoService.obtenerHorasPorMedicoIdYFecha(idMedico, fecha);
        return ResponseEntity.ok().body(horas);
    }


    @GetMapping("/fechas/{medicoId}")
    public ResponseEntity<List<HorarioTrabajoDTO>> obtenerFechasPorMedico(@PathVariable Long medicoId) {
        List<HorarioTrabajoDTO> horariosDTO = horarioTrabajoService.obtenerFechasPorMedico(medicoId);
        return ResponseEntity.ok().body(horariosDTO);
    }

}
