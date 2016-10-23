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
import javax.persistence.SequenceGenerator;

@MappedSuperclass
@Access(AccessType.PROPERTY)

public abstract class Pessoa implements Cadastro {

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

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList enderecos) {
        this.enderecos = enderecos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

}
