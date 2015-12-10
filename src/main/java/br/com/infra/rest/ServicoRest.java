package br.com.infra.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.infra.commons.util.MensagemRespostaServico;

public class ServicoRest {

	protected Response gerarMensagemDeRetorno(MensagemRespostaServico mensagem) {
		return Response.status(Status.OK).entity(buildMessage(mensagem.getCodigo(), mensagem.getMensagem())).build();
	}

	protected Response gerarMensagemDeErro(Exception e) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
	}
	
	private String buildMessage(Integer code, String message) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(code);
		buffer.append(": ");
		buffer.append(message);
		
		return buffer.toString();
	}
}
