package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import com.agendaHora.agendaHora.Models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioTrabajoRepository extends JpaRepository<HorarioTrabajo, Long> {
    List<HorarioTrabajo> findByMedico(Medico medico);
}
