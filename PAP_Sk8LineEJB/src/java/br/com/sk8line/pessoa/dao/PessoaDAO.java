/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.pessoa.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Rodrigo
 */
public class PessoaDAO extends DAO {

    /**
     * Instância da class
     */
    private static PessoaDAO instance;

    /**
     * Construtor privado, para uso com singleton
     */
    private PessoaDAO() {

    }

    /**
     *
     * Retorna uma instância da classe, trabalho com Singleton
     *
     * @return
     */
    public static PessoaDAO getInstance() {
        if (instance == null || !(instance instanceof PessoaDAO)) {
            instance = new PessoaDAO();
        }

        return instance;
    }

    /**
     * Salva a pessoa
     *
     * @param pessoa
     * @return
     */
    public Pessoa salvar(Pessoa pessoa) {

        if (pessoa.getId() == 0) {
            this.getEntityManager().persist(pessoa);
        } else {
            if (!this.getEntityManager().contains(pessoa)) {
                if (this.getEntityManager().find(Pessoa.class, pessoa.getId()) == null) {
                    throw new NotFoundException("Pessoa não encontrada");
                }
            }

            this.getEntityManager().merge(pessoa);
        }

        return pessoa;
    }

    /**
     * Lista todos os produtos
     *
     * @return
     */
    public List<Pessoa> listar() {
        EntityManager em = this.getEntityManager();
        TypedQuery query = em.createQuery("SELECT p FROM Cliente p", Pessoa.class);
        return query.getResultList();
    }

    /**
     * Obtém um produto pelo ID
     *
     * @param id
     * @return
     */
    public Pessoa getById(int id) {
        Pessoa pessoa = this.getEntityManager().find(Pessoa.class, id);
        if (pessoa == null) {
            throw new NotFoundException("Pessoa não encontrada");
        }

        return pessoa;
    }

    public void apagar(Pessoa pessoa) {
        this.getEntityManager().remove(pessoa);
    }
}
