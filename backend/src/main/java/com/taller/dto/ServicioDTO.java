package com.taller.dto;

import java.time.LocalDate;
import java.util.List;

public class ServicioDTO {

    private Long id;
    private LocalDate fecha;
    private String descripcionGeneral;
    private int kilometrajeActual;
    private double costoTotal;
    private Long vehiculoId;
    private List<DetalleServicioDTO> detalles;

    // Getters y setters
}
