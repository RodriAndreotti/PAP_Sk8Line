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
@Embeddable
public class VendaPK implements Serializable{
    @Column
    private int venda;
    @Column
    private int produto;

    public VendaPK() {
    }

    public VendaPK(int venda, int produto) {
        this.venda = venda;
        this.produto = produto;
    }
    
    

    @Override
    public boolean equals(Object o) {
        VendaPK vendaPk = (VendaPK) o;
        
        if(vendaPk.getVenda() != venda){
            return false;
        }
        
        if(vendaPk.getProduto() != produto){
            return false;
        }
        
        return true;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.venda;
        hash = 61 * hash + this.produto;
        return hash;
    }
    
    

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
    
    
}
