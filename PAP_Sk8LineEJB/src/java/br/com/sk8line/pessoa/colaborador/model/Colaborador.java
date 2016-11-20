package br.com.sk8line.pessoa.colaborador.model;

import br.com.sk8line.pessoa.model.PessoaFisica;
import br.com.sk8line.usuario.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_colaborador"))
@NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c")
public class Colaborador extends PessoaFisica implements Serializable {

    private String cargo;
    
    
    private List<ColaboradorEndereco> enderecos = new ArrayList<>();

    @Override
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    public Usuario getUsuario() {
        return super.getUsuario();
    }
    
    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<ColaboradorEndereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<ColaboradorEndereco> enderecos) {
        this.enderecos = enderecos;
    }

    
    @Override
    public Integer getId() {
        return super.getId();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
