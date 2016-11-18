/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.cliente.util;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public enum Tipo {
    PESSOA_FISICA (1),
    PESSOA_JURIDICA(2);
    
    private final int tipo;

    private Tipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
    
    public String getAsString() {
        switch(this.tipo){
            case 1: return "Pessoa Física";
            case 2: return "Pessoa Jurídica";
            default: return null;
        }
    }
}
