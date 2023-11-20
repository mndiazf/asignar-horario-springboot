package com.agendaHora.agendaHora.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HorarioTrabajoDTO {

    private Long id;
    private Date fecha;

}
