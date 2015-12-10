package br.com.infra.service;

import java.util.List;

import br.com.infra.commons.entity.Evento;

public interface IEventoService {

	/**
	 * Lista todos os eventos cadastrados
	 *
	 * @return
	 */
	public List<Evento> listarTodosOsEventos();
	
	/**
	 * Busca os eventos de um colaborador
	 * @return
	 */
	public List<Evento> listaEventosPorIdDoColaborador(Long id);

	/**
	 * Adiciona um novo Evento
	 *
	 * @param evento
	 */
	public void salvarEvento(Evento evento);

	/**
	 * Remove evento pelo id
	 *
	 * @param id
	 */
	public void removeEvento(Evento evento);

	/**
	 * Altera evento
	 * 
	 * @param evento
	 */
	public void alterarEvento(Evento evento);

}
