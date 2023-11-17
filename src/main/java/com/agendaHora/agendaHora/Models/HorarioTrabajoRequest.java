package com.agendaHora.agendaHora.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HorarioTrabajoRequest {

    private Long medicoId;
    private String diaSemana;
    private String horaInicio;
    private String horaFin;

    // Getters y setters

}

