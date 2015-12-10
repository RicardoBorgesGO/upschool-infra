package br.com.infra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.infra.commons.entity.Colaborador;
import br.com.infra.commons.entity.Evento;
import br.com.infra.dao.IEventoDAO;
import br.com.infra.service.IEventoService;

@Service
@Transactional
public class EventoServiceImpl implements IEventoService {

	@Autowired
	private IEventoDAO eventoDao;

	@Override
	public List<Evento> listarTodosOsEventos() {
		return eventoDao.buscaTodos();
	}

	@Override
	public void salvarEvento(final Evento evento) {
		eventoDao.salvar(evento);
	}

	@Override
	public void removeEvento(final Evento evento) {
		final Evento eventoThis = eventoDao.buscaPorId(evento.getId());
		eventoDao.excluir(eventoThis);
	}

	@Override
	public void alterarEvento(final Evento evento) {
		eventoDao.atualizar(evento);
	}

	@Override
	public List<Evento> listaEventosPorIdDoColaborador(Long id) {
		return eventoDao.buscaPeloIdDoColaborador(new Colaborador(id));
	}

}
