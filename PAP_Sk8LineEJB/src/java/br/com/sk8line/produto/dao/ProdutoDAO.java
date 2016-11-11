/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.produto.model.Produto;
import java.util.List;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Rodrigo
 */
public class ProdutoDAO extends DAO {

    /**
     * Instância da class
     */
    private static ProdutoDAO instance;

    /**
     * Construtor privado, para uso com singleton
     */
    private ProdutoDAO() {

    }

    /**
     *
     * Retorna uma instância da classe, trabalho com Singleton
     *
     * @return
     */
    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }

        return instance;
    }

    /**
     * Salva o produto
     *
     * @param produto
     * @return
     */
    public Produto salvar(Produto produto) {

        if (produto.getId() == 0) {
            this.getEntityManager().persist(produto);
        } else {
            if (!this.getEntityManager().contains(produto)) {
                if (this.getEntityManager().find(Produto.class, produto.getId()) == null) {
                    throw new NotFoundException("Produto não encontrado");
                }
            }

            this.getEntityManager().merge(produto);
        }

        return produto;
    }

    /**
     * Lista todos os produtos
     * @return 
     */
    public List<Produto> listar() {
        return this.getEntityManager().createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    /**
     * Obtém um produto pelo ID
     * @param id
     * @return 
     */
    public Produto getById(int id) {
        Produto produto = this.getEntityManager().find(Produto.class, id);
        if (produto == null) {
            throw new NotFoundException("Produto não encontrado");
        }
        
        return produto;
    }
    
    
    public void apagar(Produto produto) {
        this.getEntityManager().remove(produto);
    }
}
