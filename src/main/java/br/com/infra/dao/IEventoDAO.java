package br.com.infra.dao;

import java.util.List;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.Evento;

public interface IEventoDAO extends IGenericDAO<Evento> {

	/**
	 * Busca pelo id do colaborador
	 * @param id
	 * @return
	 */
	List<Evento> buscaPeloIdDoColaborador(Colaborador colaborador);
}
