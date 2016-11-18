/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.pessoa.colaborador.model.Colaborador;
import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name="colaborador_endereco")
@IdClass(RevendedorEnderecoPK.class)
class RevendedorEndereco  implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "revendedor")
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
