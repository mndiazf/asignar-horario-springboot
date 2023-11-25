package com.agendaHora.agendaHora.Controller;

import com.agendaHora.agendaHora.Models.DTOs.EspecialidadDTO;
import com.agendaHora.agendaHora.Services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "https://playerdos.com", allowedHeaders = "*")
@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    //LLama todas las especialidades
    @GetMapping("/todas")
    public ResponseEntity<List<EspecialidadDTO>> obtenerTodasEspecialidades() {
        List<EspecialidadDTO> especialidades = especialidadService.obtenerTodasEspecialidades();

        // Mapear las especialidades a DTOs
        List<EspecialidadDTO> especialidadDTOs = especialidades.stream()
                .map(especialidad -> new EspecialidadDTO(especialidad.getId(), especialidad.getNombre()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(especialidadDTOs);
    }
}
