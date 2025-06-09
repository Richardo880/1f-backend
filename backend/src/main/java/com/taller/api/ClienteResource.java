package com.taller.api;

import com.taller.dto.ClienteDTO;
import com.taller.service.ClienteServiceLocal;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    private ClienteServiceLocal clienteService;

    @GET
    public Response obtenerTodos() {
        List<ClienteDTO> clientes = clienteService.obtenerTodos();
        return Response.ok(clientes).build();
    }

    @POST
    public Response crearCliente(ClienteDTO clienteDTO) {
        try {
            clienteService.crearCliente(clienteDTO);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Tipo de cliente inválido").build();
        } catch (Exception e) {
            return Response.serverError().entity("Error al crear cliente").build();
        }
    }
}
