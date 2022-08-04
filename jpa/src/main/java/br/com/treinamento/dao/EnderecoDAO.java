package br.com.treinamento.dao;

import javax.persistence.EntityManager;

import br.com.treinamento.modelo.Endereco;

import java.util.List;

public class EnderecoDAO {

	
	private EntityManager em;

	public EnderecoDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Endereco endereco) {
		this.em.persist(endereco);
	}

	public List<Endereco> consultarPorNomePessoa(String nome) {
		String query = "SELECT e FROM Endereco e WHERE e.pessoa.nome = :nome";
		return this.em.createQuery(query, Endereco.class).setParameter("nome", nome).getResultList();
	}

}
