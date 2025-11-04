package com.example.parcial2pw.repository;


import com.example.parcial2pw.model.Asignatura;
import com.example.parcial2pw.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByDocenteEncargado(Usuario docente);
}

