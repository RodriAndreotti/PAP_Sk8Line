/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.revendedor.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Embeddable
class RevEndPK implements Serializable{
    @Column
    private int revendedor;
    
    @Column
    private int endereco;

    public RevEndPK() {
    }

    public RevEndPK(int revendedor, int endereco) {
        this.revendedor = revendedor;
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.revendedor;
        hash = 67 * hash + this.endereco;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RevEndPK other = (RevEndPK) obj;
        if (this.revendedor != other.revendedor) {
            return false;
        }
        if (this.endereco != other.endereco) {
            return false;
        }
        return true;
    }

    public int getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(int revendedor) {
        this.revendedor = revendedor;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }
    
    
}
