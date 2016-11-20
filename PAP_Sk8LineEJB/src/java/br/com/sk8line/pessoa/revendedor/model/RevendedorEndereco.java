/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.common.model.Endereco;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Entity
@Table(name="revendedor_endereco")
@IdClass(RevendedorEnderecoPK.class)
public class RevendedorEndereco  implements Serializable{

    private static final long serialVersionUID = 3136787431603416800L;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @Id
    @ManyToOne
    @JoinColumn(name = "revendedor", referencedColumnName = "id_revendedor")
    private Revendedor revendedor;

    @Id
    private int numero;
    private String Complemento;
    private int tipo;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
