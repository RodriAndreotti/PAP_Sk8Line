/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.revendedor.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.pessoa.revendedor.model.Revendedor;
import java.util.List;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author leonardo.lima
 */
public class RevendedorDAO extends DAO{
    
    private static RevendedorDAO instance;

    private RevendedorDAO() {
    }
    
    public static RevendedorDAO getInstance() {
        if (instance == null || !(instance instanceof RevendedorDAO)) {
            instance = new RevendedorDAO();
        }

        return instance;
    }

    /**
     * Salva o Revendedor
     *
     * @param Revendedor
     * @return
     */
    public Revendedor salvar(Revendedor revendedor) {

        if (revendedor.getId() == 0) {
            this.getEntityManager().persist(revendedor);
        } else {
            if (!this.getEntityManager().contains(revendedor)) {
                if (this.getEntityManager().find(Revendedor.class, revendedor.getId()) == null) {
                    throw new NotFoundException("Revendedor não encontrado");
                }
            }

            this.getEntityManager().merge(revendedor);
        }

        return revendedor;
    }

    /**
     * Lista todos os termos
     *
     * @return
     */
    public List<Revendedor> listar() {
        return this.getEntityManager().createQuery("SELECT r FROM Revendedor r", Revendedor.class).getResultList();
    }

    /**
     * Obtém um Revendedor pelo ID
     *
     * @param id
     * @return
     */
    public Revendedor getById(int id) {
        Revendedor revendedor = this.getEntityManager().find(Revendedor.class, id);
        if (revendedor == null) {
            throw new NotFoundException("Revendedor não encontrado");
        }

        return revendedor;
    }

    public void apagar(Revendedor revendedor) {
        this.getEntityManager().remove(revendedor);
    }
}
