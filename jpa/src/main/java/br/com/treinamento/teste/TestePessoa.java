package br.com.treinamento.teste;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.treinamento.dao.EnderecoDAO;
import br.com.treinamento.dao.JPAUtil;
import br.com.treinamento.dao.PessoaDAO;
import br.com.treinamento.modelo.Endereco;
import br.com.treinamento.modelo.EnderecoComplementar;
import br.com.treinamento.modelo.Pessoa;
import br.com.treinamento.util.Sexo;

public class TestePessoa {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Carlos",Sexo.MASCULINO,"teste@gmail", LocalDate.now());
        Endereco endereco = new Endereco("Minha rua", "12345", "SN", "Meu Bairro", pessoa);
        EnderecoComplementar enderecoComplementar = new EnderecoComplementar("Endereço complementar", pessoa);
        /*
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = factory.createEntityManager();
        */

        EntityManager em = JPAUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(em);
        EnderecoDAO enderecoDAO = new EnderecoDAO(em);
        
        em.getTransaction().begin();

        //em.persist(pessoa);
        endereco.setPessoa(pessoa);
        pessoa.getEnderecos().add(endereco);
        pessoa.setEnderecoComplementar(enderecoComplementar);

        pessoaDAO.cadastrar(pessoa);
        //enderecoDAO.cadastrar(endereco);

        em.getTransaction().commit();

        List<Pessoa> pessoas = pessoaDAO.consultarTodos();
        pessoas.forEach(p -> System.out.println(p.getNome()));

        List<Endereco> enderecoPorNomePessoa =  enderecoDAO.consultarPorNomePessoa("Carlos");
        System.out.println(enderecoPorNomePessoa.get(0).getBairro());

        em.close();
    }

}
