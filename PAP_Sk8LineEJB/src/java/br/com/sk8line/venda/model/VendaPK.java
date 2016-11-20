/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.venda.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */

public class VendaPK implements Serializable{

    private static final long serialVersionUID = -3788750784559875743L;
    
    private int venda;

    private int produto;

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.venda;
        hash = 67 * hash + this.produto;
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
        final VendaPK other = (VendaPK) obj;
        if (this.venda != other.venda) {
            return false;
        }
        if (this.produto != other.produto) {
            return false;
        }
        return true;
    }

   
    
    
}
