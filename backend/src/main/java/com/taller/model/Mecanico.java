package com.taller.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaIngreso;
    private String especialidad;
}
