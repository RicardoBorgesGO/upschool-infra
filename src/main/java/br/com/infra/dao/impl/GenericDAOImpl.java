package br.com.infra.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.infra.dao.IGenericDAO;

public class GenericDAOImpl<T> implements IGenericDAO<T> {

	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void salvar(final T bean) {
		getHibernateCurrentSession().persist(bean);
	}

	@Override
	public void atualizar(final T bean) {
		//TODO criar booleano para executar o flush
		getHibernateCurrentSession().merge(bean);
		getHibernateCurrentSession().flush();
	}

	@Override
	public void excluir(final T bean) {
		getHibernateCurrentSession().delete(bean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends Serializable> T buscaPorId(final E id) {
		//TODO Testar modificacao
		return (T) getHibernateCurrentSession().get(clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> buscaTodos() {
		return getHibernateCurrentSession().createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").list();
	}

	protected Session getHibernateCurrentSession() {
		return (Session) getSessionFactory().getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}