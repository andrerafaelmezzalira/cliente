package br.com.cliente.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.cliente.domain.Cliente;
import br.com.cliente.exception.CamposObrigatoriosException;
import br.com.cliente.service.ClienteService;

@Path("/cliente")
public class ClienteResource {

	Logger log = Logger.getLogger(this.getClass().getName());

	@Inject
	private ClienteService service;

	@GET
	public Response listar() {

		log.info(" rodando método listar()  ");

		List<Cliente> clientes = service.listar();

		Map<String, Object> response = new HashMap<>();
		response.put("clientes", clientes);

		return Response.ok(response).build();
	}

	@POST
	public Response insert(Cliente cliente) {

		log.info(" rodando método insert(Cliente cliente)  ");
		try {
			service.salvar(cliente);

			log.info(" Cliente de id  " + cliente.getId() + " criado com sucesso ");

			return Response.ok().entity(cliente).build();
		} catch (CamposObrigatoriosException e) {
			return Response.ok().entity(e.getMessage()).build();
		}

	}

	@PUT
	public Response update(Cliente cliente) {

		log.info(" rodando método update(Cliente cliente)  " + cliente.getId());

		try {
			service.salvar(cliente);

			log.info(" Cliente de id  " + cliente.getId() + " alterado com sucesso ");

			return Response.ok().entity(cliente).build();
		} catch (CamposObrigatoriosException e) {
			return Response.ok().entity(e.getMessage()).build();
		}
	}

	@DELETE
	public Response delete(@QueryParam("id") Integer id) {

		log.info(" rodando método delete(@QueryParam(\"id\") Integer id)  " + id);
		Cliente cliente = service.excluir(id);
		log.info(" Cliente de id  " + cliente.getId() + " excluido com sucesso ");
		return Response.ok().entity(cliente).build();

	}

}
