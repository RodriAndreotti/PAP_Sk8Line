/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.ejb;

import br.com.sk8line.produto.dao.ProdutoDAO;
import br.com.sk8line.produto.model.Estoque;
import br.com.sk8line.produto.model.Produto;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Integra as requisições vindas do cliente ao DAO
 * @author Rodrigo
 */
@Stateless
public class ProdutoBean implements ProdutoRemote {

    /**
     * Salvar
     * @param produto
     * @return 
     */
    @Override
    public Produto salvar(Produto produto) {
        if (produto.getEstoque() == null) {
            produto.setEstoque(new Estoque());
        }
        return ProdutoDAO.getInstance().salvar(produto);
    }

    /**
     * Listar
     * @return 
     */
    @Override
    public List<Produto> listar() {
        return ProdutoDAO.getInstance().listar();
    }

    /**
     * Apagar
     * @param produto
     * @return 
     */
    @Override
    public boolean apagar(Produto produto) {
        try {
            ProdutoDAO.getInstance().apagar(produto);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    /**
     * Obter produto por ID
     * @param id
     * @return
     */
    @Override
    public Produto getById(int id){
        return ProdutoDAO.getInstance().getById(id);
    }

}
