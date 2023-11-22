package com.agendaHora.agendaHora.Controller;

import com.agendaHora.agendaHora.Models.DTOs.MedicoDTO;
import com.agendaHora.agendaHora.Models.Medico;
import com.agendaHora.agendaHora.Repositories.MedicoRepository;
import com.agendaHora.agendaHora.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    //Buscar medico por especialidad
    @GetMapping("/por-especialidad/{idEspecialidad}")
    public ResponseEntity<List<MedicoDTO>> obtenerMedicosPorEspecialidad(@PathVariable Long idEspecialidad) {
        List<MedicoDTO> medicos = medicoService.obtenerMedicosPorEspecialidad(idEspecialidad);
        return ResponseEntity.ok().body(medicos);
    }


    //Buscar medico por nombre y apellido
    @GetMapping("/buscar")
    public ResponseEntity<List<MedicoDTO>> buscarMedicosPorNombreOApellido(
            @RequestParam(value = "q", required = false) String query
    ) {
        if (StringUtils.hasText(query)) {
            List<MedicoDTO> medicosDTO = medicoService.buscarMedicosPorNombreOApellido(query);
            return new ResponseEntity<>(medicosDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Obtener medico por id
    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> obtenerMedicoPorId(@PathVariable Long id) {
        MedicoDTO medicoDTO = medicoService.obtenerMedicoPorId(id);
        return new ResponseEntity<>(medicoDTO, HttpStatus.OK);
    }


}
