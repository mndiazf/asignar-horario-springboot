package com.agendaHora.agendaHora.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.validation.constraints.Pattern;


import java.util.Date;

@Entity
@Table(name = "\"horarioTrabajo\"")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Pattern (regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora incorrecto. Debe ser en formato 'HH:mm'")
    private String hora;



    // Otros campos y métodos getter/setter
}

