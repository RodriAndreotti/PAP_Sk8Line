package br.com.sk8line.produto.ejb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.sk8line.produto.model.Estoque;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo
 */
@Remote
public interface EstoqueRemote {
    public boolean inserirEstoque(Estoque e, int qtd);
    public boolean removerEstoque(Estoque e, int qtd);
}
