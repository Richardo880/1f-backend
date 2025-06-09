package com.taller.service;

import com.taller.dto.ClienteDTO;
import com.taller.model.Cliente;
import com.taller.model.Cliente.TipoCliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ClienteService implements ClienteServiceLocal {

    @PersistenceContext(unitName = "TallerPU")
    private EntityManager em;

    @Override
    public void crearCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setRuc(dto.getRuc());
        cliente.setTipo(TipoCliente.valueOf(dto.getTipo())); // "VIP", "REGULAR"...
        em.persist(cliente);
    }

    @Override
    public List<ClienteDTO> obtenerTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList()
                .stream()
                .map(this::convertirAClienteDTO)
                .collect(Collectors.toList());
    }

    private ClienteDTO convertirAClienteDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());
        dto.setRuc(cliente.getRuc());
        dto.setTipo(cliente.getTipo().name());
        return dto;
    }
}
