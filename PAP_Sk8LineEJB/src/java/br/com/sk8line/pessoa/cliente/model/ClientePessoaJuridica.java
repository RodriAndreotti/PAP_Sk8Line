package br.com.sk8line.pessoa.cliente.model;

import br.com.sk8line.pessoa.model.PessoaJuridica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_revendedor"))
public class ClientePessoaJuridica extends PessoaJuridica implements Serializable {

    
    private List<ClientePJEndereco> enderecos = new ArrayList();
    
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    public Integer getId() {
        return super.getId();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    public List<ClientePJEndereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<ClientePJEndereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    
    
}
