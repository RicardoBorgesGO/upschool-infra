package br.com.infra.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.infra.commons.entity.Paciente;
import br.com.infra.service.IPacienteService;

@Component
@Path("/paciente")
public class PacienteRest {

	@Autowired
	private IPacienteService pacienteService;
	
	@GET
	@Path("/getPacientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> getPacientes() {
		return pacienteService.buscarTodos();
	}
	
	@POST
	@Path("/setPaciente")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarPaciente(final Paciente paciente) {
		try {
			pacienteService.salvarPaciente(paciente);
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Erro ao salvar paciente. Erro: " + e).build();
		}
		return Response.status(201).entity("Paciente salvo com sucesso!").build();
	}
}
