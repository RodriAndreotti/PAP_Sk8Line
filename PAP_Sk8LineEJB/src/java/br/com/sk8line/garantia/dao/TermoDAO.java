/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.garantia.model.TermoGarantia;
import java.util.List;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Rodrigo
 */
public class TermoDAO extends DAO {

    private static TermoDAO instance;

    private TermoDAO() {
    }

    
    public static TermoDAO getInstance() {
        if (instance == null || !(instance instanceof TermoDAO)) {
            instance = new TermoDAO();
        }

        return instance;
    }

    /**
     * Salva o termo
     *
     * @param termo
     * @return
     */
    public TermoGarantia salvar(TermoGarantia termo) {

        if (termo.getId() == 0) {
            this.getEntityManager().persist(termo);
        } else {
            if (!this.getEntityManager().contains(termo)) {
                if (this.getEntityManager().find(TermoGarantia.class, termo.getId()) == null) {
                    throw new NotFoundException("Termo não encontrado");
                }
            }

            this.getEntityManager().merge(termo);
        }

        return termo;
    }

    /**
     * Lista todos os termos
     *
     * @return
     */
    public List<TermoGarantia> listar() {
        return this.getEntityManager().createQuery("SELECT t FROM TermoGarantia t", TermoGarantia.class).getResultList();
    }

    /**
     * Obtém um termo pelo ID
     *
     * @param id
     * @return
     */
    public TermoGarantia getById(int id) {
        TermoGarantia termo = this.getEntityManager().find(TermoGarantia.class, id);
        if (termo == null) {
            throw new NotFoundException("Termo não encontrado");
        }

        return termo;
    }

    public void apagar(TermoGarantia t) {
        TermoGarantia termo = this.getEntityManager().contains(t) ? t : this.getEntityManager().getReference(TermoGarantia.class,t.getId());
        this.getEntityManager().remove(termo);
    }
}
