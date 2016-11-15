/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.ejb;

import br.com.sk8line.produto.dao.EstoqueDAO;
import br.com.sk8line.produto.model.Estoque;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class EstoqueBean implements EstoqueRemote {

    @Override
    public boolean inserirEstoque(Estoque e, int qtd) {
        e.setQuantidade(e.getQuantidade()+qtd);
        e.setUltimaAtualizacao(new Date());
        return EstoqueDAO.getInstance().atualizar(e);
    }

    @Override
    public boolean removerEstoque(Estoque e, int qtd) {
        e.setQuantidade(e.getQuantidade()-qtd);
        e.setUltimaAtualizacao(new Date());
        return EstoqueDAO.getInstance().atualizar(e);
    }

    @Override
    public Estoque getById(int id) {
        return EstoqueDAO.getInstance().getById(id);
    }

}
