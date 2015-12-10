package br.com.infra.service;

import java.util.List;

import br.com.infra.commons.entity.Professor;

public interface IProfessorService {

	public List<Professor> buscarTodos();
}
