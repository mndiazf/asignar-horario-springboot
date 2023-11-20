package com.agendaHora.agendaHora.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EspecialidadDTO {

    private Long id;
    private String nombre;
}
