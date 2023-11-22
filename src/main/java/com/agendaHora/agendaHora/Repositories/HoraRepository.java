package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.Hora;
import com.agendaHora.agendaHora.Models.HorarioTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoraRepository extends JpaRepository<Hora, Long> {
    boolean existsByHoraAndHorarioTrabajo(String hora, HorarioTrabajo horarioTrabajo);

    void deleteByHorarioTrabajo(HorarioTrabajo horarioTrabajo);
}
