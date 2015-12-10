package br.com.infra.service;

import java.util.List;

import br.com.infra.commons.entity.TipoDeColaborador;

public interface ITipoDeColaboradorService {

	/**
	 * Busca todos os tipos de colaboradores
	 * @return
	 */
	List<TipoDeColaborador> buscaTodos();
}
