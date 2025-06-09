package com.taller.service;

import com.taller.dto.ClienteDTO;

import java.util.List;

public interface ClienteServiceLocal {
    void crearCliente(ClienteDTO clienteDTO);
    List<ClienteDTO> obtenerTodos();
}
