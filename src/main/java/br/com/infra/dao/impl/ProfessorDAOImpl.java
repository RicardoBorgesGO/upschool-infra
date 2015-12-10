package br.com.infra.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.infra.commons.entity.Professor;
import br.com.infra.dao.IProfessorDAO;

@Repository
public class ProfessorDAOImpl extends GenericDAOImpl<Professor> implements
		IProfessorDAO {

}
