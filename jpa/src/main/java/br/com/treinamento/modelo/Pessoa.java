package br.com.treinamento.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;

import javax.persistence.*;

import br.com.treinamento.util.Sexo;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100, nullable = false)
	private String nome;
	@Column(length = 25, nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String email;
	@Column(name = "data_nasc")
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private EnderecoComplementar enderecoComplementar;
	
	public Pessoa() {}
	
	public Pessoa(String nome, Sexo sexo, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public EnderecoComplementar getEnderecoComplementar() {
		return enderecoComplementar;
	}

	public void setEnderecoComplementar(EnderecoComplementar enderecoComplementar) {
		this.enderecoComplementar = enderecoComplementar;
	}

	/*
	 * @Temporal(TemporalType.DATE) private Date date;
	 */

}