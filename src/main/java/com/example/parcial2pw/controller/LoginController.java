package com.example.parcial2pw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.parcial2pw.model.Rol;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    @GetMapping("/home")
    public String home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ROLE_RECTOR":
                return "redirect:/rector/home";
            case "ROLE_DOCENTE":
                return "redirect:/docente/home";
            case "ROLE_ESTUDIANTE":
                return "redirect:/estudiante/home";
            default:
                return "redirect:/login?error";
        }
    }
}
