package br.com.infra.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.infra.commons.entity.Evento;
import br.com.infra.service.IEventoService;

@Component
@Path("/evento")
public class EventoRest {

	@Autowired
	private IEventoService eventoService;

	@GET
	@Path("/getEventos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> getEventos() {
		return eventoService.listarTodosOsEventos();
	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Evento> getEventoPorId(@PathParam("param") Long id) {
		return eventoService.listaEventosPorIdDoColaborador(id);
	}

	@POST
	@Path("/setEvento")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEvento(final Evento evento) {
		try {
			eventoService.salvarEvento(evento);
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Erro ao salvar evento. Erro: " + e)
					.build();
		}
		return Response.status(201).entity("Evento salvo com sucesso!").build();
	}

	@POST
	@Path("/deleteEvento")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEvento(final Evento evento) {
		try {
			eventoService.removeEvento(evento);
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Erro ao remover evento. Erro: " + e).build();
		}
		return Response.status(201).entity("Evento removido com sucesso!")
				.build();
	}

	@POST
	@Path("/updateEvento")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEvento(final Evento evento) {
		try {
			eventoService.alterarEvento(evento);
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Erro ao alterar evento. Erro: " + e).build();
		}
		return Response.status(201).entity("Evento alterado com sucesso!")
				.build();
	}

}
