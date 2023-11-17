package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Puedes añadir métodos adicionales si es necesario
}