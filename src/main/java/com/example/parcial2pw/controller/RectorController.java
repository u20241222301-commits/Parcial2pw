package com.example.parcial2pw.controller;

import com.example.parcial2pw.model.Asignatura;
import com.example.parcial2pw.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rector")
public class RectorController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/home")
    public String rectorHome(Model model) {
        model.addAttribute("asignaturas", asignaturaService.listarTodas());
        return "rector/home";
    }

    @GetMapping("/nueva")
    public String nuevaAsignaturaForm(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "rector/nueva";
    }

    @PostMapping("/guardar")
    public String guardarAsignatura(@ModelAttribute Asignatura asignatura) {
        asignaturaService.guardar(asignatura);
        return "redirect:/rector/home";
    }
}

