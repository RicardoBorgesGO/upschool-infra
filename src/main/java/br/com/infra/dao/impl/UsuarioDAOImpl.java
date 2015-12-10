package br.com.infra.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.infra.commons.entity.Usuario;
import br.com.infra.dao.IUsuarioDAO;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements
		IUsuarioDAO {

	@Override
	public Usuario realizarLogin(Usuario usuario) {
		Criteria criteria = getHibernateCurrentSession().createCriteria(Usuario.class);
		
		criteria.add(Restrictions.eq("login", usuario.getLogin()));
		criteria.add(Restrictions.eq("senha", usuario.getSenha()));
		
		return (Usuario) criteria.uniqueResult();
	}

	@Override
	public Usuario buscaPorUsuario(String userName) {
		Criteria criteria = getHibernateCurrentSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", userName));
		
		return (Usuario) criteria.uniqueResult();
	}

}
