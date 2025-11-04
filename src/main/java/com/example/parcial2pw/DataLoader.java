package com.example.parcial2pw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.parcial2pw.model.Rol;
import com.example.parcial2pw.model.Usuario;
import com.example.parcial2pw.repository.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            Usuario rector = new Usuario();
            rector.setNombre("Isa Carvajal");
            rector.setCorreo("rector@usco.edu");
            rector.setPassword("1234");
            rector.setRol(Rol.RECTOR);

            Usuario docente = new Usuario();
            docente.setNombre("Martin Carvajal");
            docente.setCorreo("docente@usco.edu");
            docente.setPassword("1234");
            docente.setRol(Rol.DOCENTE);

            Usuario estudiante = new Usuario();
            estudiante.setNombre("Pepito");
            estudiante.setCorreo("estudiante@usco.edu");
            estudiante.setPassword("1234");
            estudiante.setRol(Rol.ESTUDIANTE);

            usuarioRepository.save(rector);
            usuarioRepository.save(docente);
            usuarioRepository.save(estudiante);

            System.out.println("✅ Usuarios creados correctamente.");
        } else {
            System.out.println("⚠️ Ya existen usuarios en la base de datos, no se recrean.");
        }
    }
}


