package br.com.sk8line.pessoa.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PessoaFisica extends Pessoa {

    @Column(name="razao_social")
    private String nome;
    @Column(name = "cpf_cnpj")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
