package com.agendaHora.agendaHora.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "horarioTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hora> horas;

}


