/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.ejb;

import br.com.sk8line.produto.dao.ProdutoDAO;
import br.com.sk8line.produto.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class ProdutoBean implements ProdutoRemote {

    @Override
    public Produto salvar(Produto produto) {
        return ProdutoDAO.getInstance().salvar(produto);
    }

    @Override
    public List<Produto> listar() {
        return ProdutoDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(Produto produto) {
        try {
            ProdutoDAO.getInstance().apagar(produto);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
