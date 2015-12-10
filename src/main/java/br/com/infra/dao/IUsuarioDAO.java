package br.com.infra.dao;

import br.com.infra.commons.entity.Usuario;

public interface IUsuarioDAO extends IGenericDAO<Usuario> {

	Usuario realizarLogin(Usuario usuario);
	
	/**
	 * Busca por usuario
	 * @param userName
	 * @return
	 */
	Usuario buscaPorUsuario(String userName);

}
