package br.com.infra.service;

import java.util.List;

import br.com.infra.commons.entity.Colaborador;

public interface IColaboradorService {

	/**
	 * Busca todos os colaboradores
	 *
	 * @return
	 */
	public List<Colaborador> buscarTodosColaboradores();

	/**
	 * Salva colaborador
	 *
	 * @param colaborador
	 */
	public void salvarColaborador(Colaborador colaborador);

	/**
	 * Atualiza colaborador
	 * 
	 * @param colaborador
	 */
	public void atualizarColaborador(Colaborador colaborador);

	/**
	 * Exclui colaborador
	 * 
	 * @param colaborador
	 */
	public void excluirColaborador(Colaborador colaborador);
	
}
