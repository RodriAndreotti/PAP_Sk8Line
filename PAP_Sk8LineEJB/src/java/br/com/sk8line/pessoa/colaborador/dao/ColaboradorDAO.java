/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.colaborador.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.common.dao.EnderecoDAO;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.pessoa.colaborador.model.Colaborador;
import br.com.sk8line.pessoa.colaborador.model.ColaboradorEndereco;
import br.com.sk8line.usuario.model.Usuario;
import java.util.List;
import java.util.ListIterator;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author leonardo.lima
 */
public class ColaboradorDAO extends DAO {

    private static ColaboradorDAO instance;

    private ColaboradorDAO() {
    }

    public static ColaboradorDAO getInstance() {
        if (instance == null || !(instance instanceof ColaboradorDAO)) {
            instance = new ColaboradorDAO();
        }

        return instance;
    }

    /**
     * Salva o colaborador
     *
     * @param colaborador
     * @return
     */
    public Colaborador salvar(Colaborador colaborador) {

        if (colaborador.getId() == null) {
            this.getEntityManager().persist(colaborador);
            this.getEntityManager().flush();
            ListIterator<ColaboradorEndereco> end = colaborador.getEnderecos().listIterator();
            while (end.hasNext()) {
                ColaboradorEndereco endereco = (ColaboradorEndereco) end.next();
                endereco.setEndereco(this.getEntityManager().find(Endereco.class, endereco.getEndereco().getId()));

                this.getEntityManager().merge(endereco);
            }
        } else {
            if (!this.getEntityManager().contains(colaborador)) {
                if (this.getEntityManager().find(Colaborador.class, colaborador.getId()) == null) {
                    throw new NotFoundException("Colaborador não encontrado");
                }
            }

            this.getEntityManager().merge(colaborador);
        }

        return colaborador;
    }

    /**
     * Lista todos os colaboradores
     *
     * @return
     */
    public List<Colaborador> listar() {
        return this.getEntityManager().createNamedQuery("Colaborador.findAll", Colaborador.class).getResultList();
    }

    /**
     * Obtém um colaborador pelo ID
     *
     * @param id
     * @return
     */
    public Colaborador getById(int id) {
        Colaborador colaborador = this.getEntityManager().find(Colaborador.class, id);
        if (colaborador == null) {
            throw new NotFoundException("Termo não encontrado");
        }

        return colaborador;
    }

    public void apagar(Colaborador c) {
        Colaborador colaborador = this.getEntityManager().contains(c) ? c : this.getEntityManager().getReference(Colaborador.class, c.getId());
        ListIterator<ColaboradorEndereco> end = colaborador.getEnderecos().listIterator();
        while (end.hasNext()) {
             this.getEntityManager().remove((ColaboradorEndereco) end.next());
        }
        Usuario user = colaborador.getUsuario();
        
        this.getEntityManager().remove(colaborador);
        this.getEntityManager().remove(user);
    }
}
