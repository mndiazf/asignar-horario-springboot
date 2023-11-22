package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HorarioTrabajoRepository extends JpaRepository<HorarioTrabajo, Long> {

    List<HorarioTrabajo> findByMedicoId(Long medicoId);

    boolean existsByFechaAndMedico_Id(Date fecha, Long medicoId);

}


