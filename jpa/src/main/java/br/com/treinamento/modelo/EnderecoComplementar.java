package br.com.treinamento.modelo;

import javax.persistence.*;

@Entity
@Table(name = "endereco_complementar")
public class EnderecoComplementar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    public Pessoa pessoa;

    public EnderecoComplementar() {}

    public EnderecoComplementar(String name, Pessoa pessoa) {
        this.name = name;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
