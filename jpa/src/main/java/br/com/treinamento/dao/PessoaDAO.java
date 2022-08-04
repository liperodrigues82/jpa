package br.com.treinamento.dao;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Pessoa;

import java.util.List;

public class PessoaDAO {

	private EntityManager em;

	public PessoaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pessoa pessoa) {
		this.em.persist(pessoa);
	}

	public void remover(Pessoa pessoa) {
		this.em.merge(pessoa);
		this.em.remove(pessoa);
	}

	public List<Pessoa> consultarTodos() {
		String query = "SELECT p FROM Pessoa p";
		return this.em.createQuery(query).getResultList();
	}
}
