package br.com.infra.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.Evento;
import br.com.infra.dao.IEventoDAO;

@Repository
public class EventoDAOImpl extends GenericDAOImpl<Evento> implements IEventoDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Evento> buscaPeloIdDoColaborador(Colaborador colaborador) {
		Criteria criteria = getHibernateCurrentSession().createCriteria(Evento.class);
		criteria.add(Restrictions.eq("colaborador", colaborador));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
	}

}
