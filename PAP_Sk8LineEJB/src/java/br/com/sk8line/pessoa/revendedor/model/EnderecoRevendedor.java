/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.common.model.Endereco;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Entity
@Table(name = "endereco_revendedor")
public class EnderecoRevendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RevEndPK pk;
    
    @OneToOne
    private Revendedor revendedor;
    
    @OneToOne
    private Endereco endereco;
    
    private int numero;
    private String complemento;
    private int tipo;

    public RevEndPK getPk() {
        return pk;
    }

    public void setPk(RevEndPK pk) {
        this.pk = pk;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
