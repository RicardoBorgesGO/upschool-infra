package br.com.infra.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infra.commons.constant.EnumAtivoInativo;
import br.com.infra.commons.entity.Colaborador;
import br.com.infra.dao.IColaboradorDAO;
import br.com.infra.service.IColaboradorService;
import br.com.infra.service.ITenantService;

@Service
@Transactional
public class ColaboradorServiceImpl implements IColaboradorService {

	@Autowired
	private IColaboradorDAO dao;
	
	@Autowired
	private ITenantService tenantService;

	@Override
	public List<Colaborador> buscarTodosColaboradores() {
		List<Colaborador> colaboradores = dao.buscaTodos();
		
		Collections.sort(colaboradores, new Comparator<Colaborador>() {
			@Override
			public int compare(Colaborador colaborador1, Colaborador colaborador2) {
				return colaborador1.getNome().compareTo(colaborador2.getNome());
			}
			
		});
		
		return colaboradores;
	}

	@Override
	public void salvarColaborador(final Colaborador colaborador) {
		if (colaborador.getId() == null) {
			colaborador.setAtivoInativo(EnumAtivoInativo.A);
			dao.salvar(colaborador);
		} else {
			dao.atualizar(colaborador);
		}
	}

	@Override
	public void excluirColaborador(final Colaborador colaborador) {
		final Colaborador colaboradorThis = dao.buscaPorId(colaborador.getId());
		dao.excluir(colaboradorThis);
	}

	@Override
	public void atualizarColaborador(final Colaborador colaborador) {
		dao.atualizar(colaborador);
	}

}
