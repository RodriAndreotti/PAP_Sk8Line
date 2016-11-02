package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.pessoa.model.PessoaJuridica;
import br.com.sk8line.usuario.model.Usuario;
import java.util.ArrayList;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @OneToOne(mappedBy = "usuario", targetEntity = Usuario.class)
    public Usuario getUsuario() {
        return super.getUsuario(); 
    }

    @Override
    @OneToMany
    @JoinTable(name="revendedor_endereco", joinColumns = {@JoinColumn(name = "revendedor", referencedColumnName = "id")})
    @ElementCollection(targetClass = EnderecoRevendedor.class)
    public ArrayList<Endereco> getEnderecos() {
        return super.getEnderecos(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
