package com.agendaHora.agendaHora.Controller;

import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import com.agendaHora.agendaHora.Models.HorarioTrabajoRequest;
import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Services.HorarioTrabajoService;
import com.agendaHora.agendaHora.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/horarios-trabajo")
public class HorarioTrabajoController {

    @Autowired
    private HorarioTrabajoService horarioTrabajoService;

    @Autowired
    private MedicoService medicoService;

    @PostMapping("/asignar")
    public ResponseEntity<HorarioTrabajo> asignarHorarioTrabajo(@RequestBody HorarioTrabajoRequest request) {
        Medico medico = medicoService.obtenerMedicoPorId(request.getMedicoId());
        HorarioTrabajo horarioTrabajo = horarioTrabajoService.asignarHorarioTrabajo(
                medico,
                request.getDiaSemana(),
                request.getHoraInicio(),
                request.getHoraFin()
        );
        return ResponseEntity.ok().body(horarioTrabajo);
    }

    @DeleteMapping("/borrar/{horarioId}")
    public ResponseEntity<Void> borrarHorarioTrabajo(@PathVariable Long horarioId) {
        horarioTrabajoService.borrarHorarioTrabajo(horarioId);
        return ResponseEntity.noContent().build();
    }

    // En tu controlador (HorarioTrabajoController.java)
    @PutMapping("/modificar/{horarioId}")
    public ResponseEntity<HorarioTrabajo> modificarHora(@PathVariable Long horarioId, @RequestBody HorarioTrabajoRequest horarioTrabajoDto) {
        try {
            HorarioTrabajo horarioTrabajo = horarioTrabajoService.modificarHora(horarioId, horarioTrabajoDto);
            return new ResponseEntity<>(horarioTrabajo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<HorarioTrabajo>> obtenerHorariosPorMedico(@PathVariable Long medicoId) {
        Medico medico = medicoService.obtenerMedicoPorId(medicoId);
        List<HorarioTrabajo> horarios = horarioTrabajoService.obtenerHorariosPorMedico(medico);
        return ResponseEntity.ok().body(horarios);
    }

    // Otros métodos según las necesidades de tu aplicación

}
