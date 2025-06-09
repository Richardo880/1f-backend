package com.taller.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String chapa;
    private String modelo;
    private int anho;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipo;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Servicio> servicios;

    public enum TipoVehiculo {
        MOTO, COCHE, CAMIONETA, CAMION
    }
}
