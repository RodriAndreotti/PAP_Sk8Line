/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.common.dao;

import br.com.sk8line.common.model.Estado;
import br.com.sk8line.usuario.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Absgtrai o acesso ao banco para os estados
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class EstadoDAO extends DAO {

    private static EstadoDAO instance;

    /**
     * Retorna a instância da classe singleton
     *
     * @return
     */
    public static EstadoDAO getInstance() {
        if (instance == null) {
            instance = new EstadoDAO();
        }

        return instance;
    }

    private EstadoDAO() {
    }

    /**
     * Obtém um estado pelo ID
     *
     * @param id
     * @return
     */
    public Estado getById(int id) {
        return this.getEntityManager().find(Estado.class, id);
    }

    /**
     * Obtém um estado pelo UF
     *
     * @param uf
     * @return
     */
    public Estado getByUf(String uf) {
        Estado estado;
        CriteriaBuilder builder = this.getCriteriaBuilder();
        CriteriaQuery<Estado> estadoQuery = builder.createQuery(Estado.class);
        Root<Estado> est = estadoQuery.from(Estado.class);

        try {

            TypedQuery<Estado> typedQuery = this.getEntityManager().createQuery(
                    estadoQuery
                            .where(
                                    builder.like(est.<String>get("uf"), uf)
                            )
            );

            estado = typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            estado = null;
        }

        return estado;
    }

    /**
     * Lista todos os estados
     *
     * @return
     */
    public List<Estado> listar() {
        return this.getEntityManager().createQuery("SELECT uf FROM Estado uf", Estado.class).getResultList();
    }
}
