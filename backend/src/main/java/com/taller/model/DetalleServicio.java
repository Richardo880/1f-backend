package com.taller.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class DetalleServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcionTrabajo;
    private double costo;

    @ManyToOne
    private Servicio servicio;

    @ManyToMany
    @JoinTable(
            name = "detalle_repuesto",
            joinColumns = @JoinColumn(name = "detalle_id"),
            inverseJoinColumns = @JoinColumn(name = "repuesto_id")
    )
    private List<Repuesto> repuestos;

    @ManyToMany
    @JoinTable(
            name = "detalle_mecanico",
            joinColumns = @JoinColumn(name = "detalle_id"),
            inverseJoinColumns = @JoinColumn(name = "mecanico_id")
    )
    private List<Mecanico> mecanicos;
}
