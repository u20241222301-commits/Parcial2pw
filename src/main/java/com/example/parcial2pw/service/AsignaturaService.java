package com.example.parcial2pw.service;

import com.example.parcial2pw.model.Asignatura;
import com.example.parcial2pw.model.Usuario;
import com.example.parcial2pw.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> listarTodas() {
        return asignaturaRepository.findAll();
    }

    public List<Asignatura> listarPorDocente(Usuario docente) {
        return asignaturaRepository.findByDocenteEncargado(docente);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura buscarPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}


