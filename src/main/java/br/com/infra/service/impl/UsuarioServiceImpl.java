package br.com.infra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infra.commons.entity.Usuario;
import br.com.infra.dao.IUsuarioDAO;
import br.com.infra.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO dao;
	
	@Override
	public Usuario realizarLogin(Usuario usuario) {
		return dao.realizarLogin(usuario);
	}

	@Override
	public Usuario buscaPorLogin(String userName) {
		return dao.buscaPorUsuario(userName);
	}

	@Override
	public Usuario buscaPorId(int id) {
		return dao.buscaPorId(id);
	}

}
