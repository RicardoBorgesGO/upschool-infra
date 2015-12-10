package br.com.infra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infra.commons.entity.Professor;
import br.com.infra.dao.IProfessorDAO;
import br.com.infra.service.IProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	private IProfessorDAO dao;

	public ProfessorServiceImpl() {
		super();
	}

	@Override
	public List<Professor> buscarTodos() {
		return dao.buscaTodos();
	}

}
