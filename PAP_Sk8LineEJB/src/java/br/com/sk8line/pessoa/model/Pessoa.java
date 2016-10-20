package br.com.sk8line.pessoa.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.usuario.model.Usuario;
import java.util.ArrayList;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.PROPERTY)
public abstract class Pessoa implements Cadastro {

    @Id
    private int id;

    private String nome;

    private String telefone;

    private ArrayList enderecos;

    private Usuario usuario;

    /**
     * @see model.Cadastro#addEndereco(model.Endereco)
     */
    public void addEndereco(Endereco endereco) {

    }

    /**
     * @see model.Cadastro#delEndereco(model.Endereco)
     */
    public void delEndereco(Endereco endereco) {

    }

    /**
     * @see model.Cadastro#cadastrar()
     */
    public void cadastrar() {

    }

    /**
     * @see model.Cadastro#editar()
     */
    public void editar() {

    }

    /**
     * @see model.Cadastro#apagar()
     */
    public void apagar() {

    }

}
