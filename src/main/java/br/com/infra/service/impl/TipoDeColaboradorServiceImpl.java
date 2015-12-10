package br.com.infra.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infra.commons.entity.TipoDeColaborador;
import br.com.infra.dao.ITipoDeColaboradorDAO;
import br.com.infra.service.ITipoDeColaboradorService;

@Service
@Transactional
public class TipoDeColaboradorServiceImpl implements ITipoDeColaboradorService {

	@Autowired
	private ITipoDeColaboradorDAO tipoDeColaboradorDAO;
	
	@Override
	public List<TipoDeColaborador> buscaTodos() {
		return tipoDeColaboradorDAO.buscaTodos();
	}

}
