package com.taller.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String descripcionGeneral;
    private int kilometrajeActual;
    private double costoTotal;

    @ManyToOne
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<DetalleServicio> detalles;
}

