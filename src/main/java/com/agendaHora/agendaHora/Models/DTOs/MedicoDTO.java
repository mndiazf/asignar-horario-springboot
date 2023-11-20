package com.agendaHora.agendaHora.Models.DTOs;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;


}
