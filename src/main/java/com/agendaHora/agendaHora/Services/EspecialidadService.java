package com.agendaHora.agendaHora.Services;

import com.agendaHora.agendaHora.Models.DTOs.EspecialidadDTO;
import com.agendaHora.agendaHora.Models.Especialidad;
import com.agendaHora.agendaHora.Repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<EspecialidadDTO> obtenerTodasEspecialidades() {
        List<Especialidad> especialidadesData = especialidadRepository.findAll();

        return especialidadesData.stream()
                .map(especialidad -> new EspecialidadDTO(especialidad.getId(), especialidad.getNombre()))
                .collect(Collectors.toList());
    }
}
