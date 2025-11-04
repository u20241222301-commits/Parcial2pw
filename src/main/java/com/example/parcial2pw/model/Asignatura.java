package com.example.parcial2pw.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private int salon;
    private String horaInicio;
    private String horaFin;

    @ManyToOne
    private Usuario docenteEncargado;

}

