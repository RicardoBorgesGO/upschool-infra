package br.com.infra.service;

import java.util.List;

import br.com.infra.commons.entity.Paciente;

public interface IPacienteService {

	List<Paciente> buscarTodos();
	
	/**
	 * Salva paciente
	 * @param paciente
	 */
	void salvarPaciente(Paciente paciente);
}
