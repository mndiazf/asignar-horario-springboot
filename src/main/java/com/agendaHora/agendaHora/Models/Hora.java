package com.agendaHora.agendaHora.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"hora\"")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "horario_trabajo_id", nullable = false)
    private HorarioTrabajo horarioTrabajo;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora incorrecto. Debe ser en formato 'HH:mm'")
    private String hora;

    // Otros campos y métodos getter/setter
}
