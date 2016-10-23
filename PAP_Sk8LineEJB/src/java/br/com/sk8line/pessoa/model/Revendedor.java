package br.com.sk8line.pessoa.model;

import br.com.sk8line.common.model.Endereco;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_revendedor"))
@SequenceGenerator(name = "RevSEQ", allocationSize = 1)
public class Revendedor extends PessoaJuridica {

    public void addEndereco(Endereco endereco) {

    }

    public void delEndereco(Endereco endereco) {

    }

    public void cadastrar() {

    }

    public void editar() {

    }

    public void apagar() {

    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "RevSEQ")
    public int getId() {
        return super.getId();
    }
}
