package br.com.sk8line.pessoa.cliente.model;

import br.com.sk8line.pessoa.model.PessoaFisica;
import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_revendedor"))
public class ClientePessoaFisica extends PessoaFisica implements Serializable{

    
    private List<ClientePFEndereco> enderecos = new java.util.ArrayList<>();
    
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return super.getId();
    }


    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    public List<ClientePFEndereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<ClientePFEndereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
}
