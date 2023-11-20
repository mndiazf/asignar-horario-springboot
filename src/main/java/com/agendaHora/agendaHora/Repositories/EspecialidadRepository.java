package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}
