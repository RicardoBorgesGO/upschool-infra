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

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.infra.commons.util.MensagemRespostaServico;
import br.com.infra.service.IColaboradorService;
import br.com.infra.service.ITipoDeColaboradorService;

@Component
@Path("/colaborador")
public class ColaboradorRest extends ServicoRest {

	@Autowired
	private IColaboradorService colaboradorService;

	@Autowired
	private ITipoDeColaboradorService tipoDeColaboradorService;

	@GET
	@Path("/getColaboradores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Colaborador> getColaboradores() {
		return colaboradorService.buscarTodosColaboradores();
	}

	@POST
	@Path("/setColaborador")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarColaborador(final Colaborador colaborador) {
		try {
			colaboradorService.salvarColaborador(colaborador);
		} catch (final Exception e) {
			e.printStackTrace();
			return gerarMensagemDeRetorno(MensagemRespostaServico.ERRO_NAO_SALVO);
			// return Response.status(500)
			// .entity("Erro ao salvar colaborador. Erro: " + e).build();
		}
		return gerarMensagemDeRetorno(MensagemRespostaServico.SUCESSO_SALVAR);
	}

	@GET
	@Path("getTiposDeColaboradores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDeColaborador> getTiposDeColaboradores() {
		return tipoDeColaboradorService.buscaTodos();
	}

	@POST
	@Path("/deleteColaborador")
	@Consumes(MediaType.APPLICATION_JSON)
	@Deprecated
	public Response excluirColaborador(final Colaborador colaborador) {
		try {
			colaboradorService.excluirColaborador(colaborador);
		} catch (final Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Erro ao excluir colaborador. Erro: " + e).build();
		}
		return Response.status(201).entity("Colaborador excluido com sucesso!").build();
	}
}
