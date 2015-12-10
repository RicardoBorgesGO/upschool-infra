package br.com.infra.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.infra.service.ITenantService;

@Component
@Path("/tenant")
public class TenantRest extends ServicoRest {

	@Autowired
	private ITenantService tenantService;
	
	@POST
	@Path("/setTenant")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setTenant(String tenant) {
		try {
			tenantService.setTenantSchemaName(tenant);
		} catch(Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro ao salvar evento. Erro: " + e).build();
		}
		return Response.status(201).entity("Evento salvo com sucesso!").build();
	}
}
