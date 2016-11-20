/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.garantia.model.Rma;
import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.venda.model.Venda;
import java.util.List;
import java.util.ListIterator;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class RmaDAO extends DAO {

    private static RmaDAO instance;

    public static RmaDAO getInstance() {
        if (instance == null) {
            instance = new RmaDAO();
        }

        return instance;
    }

    private RmaDAO() {
    }

    public List<Rma> listar() {
        return this.getEntityManager().createNamedQuery("Rma.findAll", Rma.class).getResultList();
    }

    /**
     * Salva a solicitação de Garantia
     *
     * @param rma
     * @return
     */
    public Rma salvar(Rma rma) {

        if (rma.getId() == 0) {
            rma.setVenda(this.getEntityManager().find(Venda.class, rma.getVenda().getId()));
            rma.setProduto(this.getEntityManager().find(Produto.class, rma.getProduto().getId()));
            this.getEntityManager().persist(rma);
            this.getEntityManager().flush();
        } else {
            if (!this.getEntityManager().contains(rma)) {
                if (this.getEntityManager().find(Rma.class, rma.getId()) == null) {
                    throw new NotFoundException("Rma não encontrado");
                }
            }
            this.getEntityManager().merge(rma);
        }

        return rma;
    }

    /**
     * Obtém uma RMA pelo ID
     *
     * @param id
     * @return
     */
    public Rma getById(int id) {
        Rma rma = this.getEntityManager().find(Rma.class, id);
        if (rma == null) {
            throw new NotFoundException("Venda não encontrada");
        }

        return rma;
    }

    public void apagar(Rma rma) {
        this.getEntityManager().remove(rma);
    }
}
