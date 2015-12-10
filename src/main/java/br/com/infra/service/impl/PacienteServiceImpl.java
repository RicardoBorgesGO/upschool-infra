package br.com.infra.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infra.commons.entity.Paciente;
import br.com.infra.dao.IPacienteDAO;
import br.com.infra.service.IPacienteService;

@Service
@Transactional
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteDAO pacienteDAO;
	
	@Override
	public List<Paciente> buscarTodos() {
		List<Paciente> pacientes = pacienteDAO.buscaTodos();
		
		Collections.sort(pacientes, new Comparator<Paciente>() {
			@Override
			public int compare(Paciente paciente1, Paciente paciente2) {
				return paciente1.getNome().compareTo(paciente2.getNome());
			}
			
		});
		
		return pacientes;
	}

	@Override
	public void salvarPaciente(final Paciente paciente) {
		if (paciente.getId() == null)
			pacienteDAO.salvar(paciente);
		else
			pacienteDAO.atualizar(paciente);
	}

}
