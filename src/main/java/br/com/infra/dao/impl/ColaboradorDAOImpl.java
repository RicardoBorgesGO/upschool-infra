package br.com.infra.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.dao.IColaboradorDAO;

@Repository
public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador> implements
		IColaboradorDAO {
}
