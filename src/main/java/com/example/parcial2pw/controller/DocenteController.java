package com.example.parcial2pw.controller;

import com.example.parcial2pw.model.Asignatura;
import com.example.parcial2pw.model.Usuario;
import com.example.parcial2pw.service.AsignaturaService;
import com.example.parcial2pw.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private UsuarioService usuarioService;

    // Vista principal del docente
    @GetMapping("/home")
    public String docenteHome(@RequestParam("correo") String correo, Model model) {
        Usuario docente = usuarioService.buscarPorCorreo(correo);
        if (docente == null) {
            model.addAttribute("error", "No se encontró el usuario docente.");
            return "error";
        }

        List<Asignatura> asignaturas = asignaturaService.listarPorDocente(docente);
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("docente", docente);
        return "docente/home";
    }

    // Formulario para editar horario
    @GetMapping("/editar/{id}")
    public String editarAsignatura(@PathVariable Long id, Model model) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);
        model.addAttribute("asignatura", asignatura);
        return "docente/editar";
    }

    // Guardar el nuevo horario
    @PostMapping("/actualizar")
    public String actualizarHorario(@ModelAttribute Asignatura asignatura) {
        Asignatura existente = asignaturaService.buscarPorId(asignatura.getId());
        if (existente != null) {
            existente.setHoraInicio(asignatura.getHoraInicio());
            existente.setHoraFin(asignatura.getHoraFin());
            asignaturaService.guardar(existente);
        }
        return "redirect:/docente/home?correo=" + existente.getDocenteEncargado().getCorreo();
    }
}


