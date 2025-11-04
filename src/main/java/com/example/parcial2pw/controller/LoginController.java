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

  
}
