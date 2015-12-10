package br.com.infra.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.infra.commons.entity.Usuario;
import br.com.infra.service.IUsuarioService;

@Component
@Path("/usuario")
public class UsuarioRest extends ServicoRest {

	@Autowired
	private IUsuarioService usuarioService;

	@POST
	@Path("/realizarLogin")
	@Consumes(MediaType.APPLICATION_JSON)
	public String realizarLogin(final Usuario usuario) {
		try {
			Usuario usuarioCadastrado = usuarioService.realizarLogin(usuario);
			if (usuarioCadastrado == null) {
				return "false";
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "true";
	}
	
	@GET
	@Path("/userName/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario consultaPorLogin(@PathParam("userName") String userName) {
		try {
			Usuario usuarioCadastrado = usuarioService.buscaPorLogin(userName);
			if (usuarioCadastrado != null) {
				return usuarioCadastrado;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario consultaPorId(@PathParam("id") Integer id) {
		try {
			Usuario usuarioCadastrado = usuarioService.buscaPorId(id);
			if (usuarioCadastrado != null) {
				return usuarioCadastrado;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
