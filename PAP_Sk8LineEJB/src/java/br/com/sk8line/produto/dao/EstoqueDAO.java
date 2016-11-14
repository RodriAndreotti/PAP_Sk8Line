/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.produto.model.Estoque;
import javax.ws.rs.NotFoundException;

/**
 * Abstrai o acesso ao banco para o estoque
 *
 * @author Rodrigo
 */
public class EstoqueDAO extends DAO {

    private static EstoqueDAO instance;

    private EstoqueDAO() {
    }

    public static EstoqueDAO getInstance() {
        if (instance == null) {
            instance = new EstoqueDAO();
        }

        return instance;
    }

    public boolean atualizar(Estoque e) {
        try {
            if (!this.getEntityManager().contains(e)) {
                if (this.getEntityManager().find(Estoque.class, e.getId()) == null) {
                    throw new NotFoundException("Produto não encontrado");
                }
            }
            this.getEntityManager().merge(e);
            return true;
        } catch (NotFoundException ex) {
            return false;
        }
    }
}
