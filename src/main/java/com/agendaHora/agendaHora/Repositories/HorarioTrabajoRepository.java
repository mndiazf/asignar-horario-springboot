package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HorarioTrabajoRepository extends JpaRepository<HorarioTrabajo, Long> {
    List<HorarioTrabajo> findByFecha(Date fecha);
    List<HorarioTrabajo> findByMedicoId(Long medicoId);

    @Query("SELECT h.hora FROM HorarioTrabajo h WHERE h.medico.id = :idMedico AND h.fecha = :fecha")
    List<String> findHorasByMedicoIdAndFecha(@Param("idMedico") Long idMedico, @Param("fecha") Date fecha);
}


