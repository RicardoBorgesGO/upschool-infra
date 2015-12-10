package br.com.infra.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T> {

	public void salvar(T bean);

	public void excluir(T bean);

	public void atualizar(T bean);

	public <E extends Serializable> T buscaPorId(final E id);

	public List<T> buscaTodos();
}
