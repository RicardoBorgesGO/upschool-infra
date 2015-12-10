package br.com.infra.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.infra.commons.entity.Professor;
import br.com.infra.service.IProfessorService;

@Component
@Path("/professor")
public class ProfessorRest {

	@Autowired
	private IProfessorService service;

	@GET
	@Path("/getProfessores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessores() {
		return service.buscarTodos();
	}
}
