package com.agendaHora.agendaHora.Repositories;

import com.agendaHora.agendaHora.Models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m.id, m.nombre, m.apellido, m.email FROM Medico m JOIN m.especialidades e WHERE e.id = :idEspecialidad")
    List<Object[]> findMedicosByEspecialidadId(@Param("idEspecialidad") Long idEspecialidad);


    @Query("SELECT m.id, m.nombre, m.apellido, m.email FROM Medico m WHERE LOWER(CONCAT(m.nombre, ' ', m.apellido)) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Object[]> buscarPorNombreOApellido(@Param("query") String query);
}