/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.revendedor.model;

import java.io.Serializable;
import javax.persistence.Column;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class RevendedorEnderecoPK implements Serializable{
    private int endereco;
    private int revendedor;
    private int numero;

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(int revendedor) {
        this.revendedor = revendedor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.endereco;
        hash = 89 * hash + this.revendedor;
        hash = 89 * hash + this.numero;
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
        final RevendedorEnderecoPK other = (RevendedorEnderecoPK) obj;
        if (this.endereco != other.endereco) {
            return false;
        }
        if (this.revendedor != other.revendedor) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
}
