package br.com.sk8line.pessoa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AttributeOverride(column = @Column(name="razao_social"), name = "nome")
public class PessoaJuridica extends Pessoa {

    private static final long serialVersionUID = 7685410519267752098L;

    @Column(name="cpf_cnpj")
    private String cnpj;


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
