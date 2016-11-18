package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.pessoa.model.PessoaJuridica;
import br.com.sk8line.usuario.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "revendedor")
public class Revendedor extends PessoaJuridica implements Serializable {
    
    private String telefone;
    

    private List<RevendedorEndereco> enderecos = new ArrayList<>();

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return super.getId();
    }

    @OneToOne(mappedBy = "usuario", targetEntity = Usuario.class)
    @Override
    public Usuario getUsuario() {
        return super.getUsuario();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revendedor")
    public List<RevendedorEndereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<RevendedorEndereco> enderecos) {
        this.enderecos = enderecos;
    }
    

}
