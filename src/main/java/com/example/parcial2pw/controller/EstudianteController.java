package com.example.parcial2pw.controller;

import com.example.parcial2pw.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/home")
    public String estudianteHome(Model model) {
        model.addAttribute("asignaturas", asignaturaService.listarTodas());
        return "estudiante/home";
    }
}
