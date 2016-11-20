package br.com.sk8line.pessoa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AttributeOverrides({
    @AttributeOverride(column = @Column(name = "razao_social"), name = "nome"),
    @AttributeOverride(column = @Column(name = "cpf_cnpj"), name = "cpf")
})
public class PessoaFisica extends Pessoa {

    
    private String nome;
    
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
