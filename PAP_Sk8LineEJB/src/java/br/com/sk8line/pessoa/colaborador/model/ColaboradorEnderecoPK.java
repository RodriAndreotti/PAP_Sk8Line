/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.colaborador.model;

import java.io.Serializable;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class ColaboradorEnderecoPK implements Serializable{
    private int endereco;
    private int colaborador;
    private int numero;

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getColaborador() {
        return colaborador;
    }

    public void setColaborador(int colaborador) {
        this.colaborador = colaborador;
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
        hash = 89 * hash + this.colaborador;
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
        final ColaboradorEnderecoPK other = (ColaboradorEnderecoPK) obj;
        if (this.endereco != other.endereco) {
            return false;
        }
        if (this.colaborador != other.colaborador) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
}
