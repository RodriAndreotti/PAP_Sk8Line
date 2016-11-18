/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.cliente.model;

import java.io.Serializable;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class ClienteEnderecoPK implements Serializable{
    private int endereco;
    private int cliente;
    private int numero;

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getColaborador() {
        return cliente;
    }

    public void setColaborador(int cliente) {
        this.cliente = cliente;
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
        hash = 89 * hash + this.cliente;
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
        final ClienteEnderecoPK other = (ClienteEnderecoPK) obj;
        if (this.endereco != other.endereco) {
            return false;
        }
        if (this.cliente != other.cliente) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
}
