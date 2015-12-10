package br.com.infra.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.infra.commons.entity.Paciente;
import br.com.infra.dao.IPacienteDAO;

@Repository
public class PacienteDAOImpl extends GenericDAOImpl<Paciente> implements IPacienteDAO {

}
