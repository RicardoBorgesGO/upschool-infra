package br.com.infra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infra.commons.entity.Curso;
import br.com.infra.dao.ICursoDAO;
import br.com.infra.service.ICursoService;

@Service
@Transactional
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoDAO dao;

	public CursoServiceImpl() {
		super();
	}

	@Override
	public List<Curso> buscarTodos() {
		return dao.buscaTodos();
	}

}
