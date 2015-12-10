package br.com.infra.service;

import br.com.infra.commons.entity.Usuario;

public interface IUsuarioService {

	Usuario realizarLogin(Usuario usuario);
	
	/**
	 * 
	 * @param usuario
	 * @return
	 */
	Usuario buscaPorLogin(String usuario);
	
	Usuario buscaPorId(int id);
}
