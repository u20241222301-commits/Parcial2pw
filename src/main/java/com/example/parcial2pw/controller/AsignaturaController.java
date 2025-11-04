package com.example.parcial2pw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.parcial2pw.model.Asignatura;
import com.example.parcial2pw.repository.AsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaRepository asignaturaRepo;

    // 📋 Mostrar lista de asignaturas
    @GetMapping("/lista")
    public String listarAsignaturas(Model model) {
        List<Asignatura> asignaturas = asignaturaRepo.findAll();
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturas/lista";
    }

    // ➕ Mostrar formulario para nueva asignatura
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "asignaturas/formulario";
    }

    // 💾 Guardar nueva asignatura o actualizar una existente
    @PostMapping("/guardar")
    public String guardarAsignatura(@ModelAttribute Asignatura asignatura) {
        asignaturaRepo.save(asignatura);
        return "redirect:/asignaturas/lista";
    }

    // ✏️ Editar una asignatura existente
    @GetMapping("/editar/{id}")
    public String editarAsignatura(@PathVariable Long id, Model model) {
        Optional<Asignatura> asignatura = asignaturaRepo.findById(id);
        if (asignatura.isPresent()) {
            model.addAttribute("asignatura", asignatura.get());
            return "asignaturas/formulario";
        }
        return "redirect:/asignaturas/lista";
    }

    // 🗑️ Eliminar asignatura
    @GetMapping("/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Long id) {
        asignaturaRepo.deleteById(id);
        return "redirect:/asignaturas/lista";
    }
}

