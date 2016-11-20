/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.pessoa.revendedor.model.Revendedor;
import br.com.sk8line.pessoa.revendedor.model.RevendedorEndereco;
import br.com.sk8line.usuario.model.Usuario;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.LockModeType;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author leonardo.lima
 */
public class RevendedorDAO extends DAO {

    private static RevendedorDAO instance;

    private RevendedorDAO() {
    }

    public static RevendedorDAO getInstance() {
        if (instance == null) {
            instance = new RevendedorDAO();
        }

        return instance;
    }


    /**
     * Salva o Revendedor
     * @param revendedor
     * @return 
     */
    public Revendedor salvar(Revendedor revendedor) {
        
        if (revendedor.getId() == null) {
           
            
            ListIterator<RevendedorEndereco> end = revendedor.getEnderecos().listIterator();
            while (end.hasNext()) {
                RevendedorEndereco endereco = (RevendedorEndereco) end.next();
                endereco.setEndereco(this.getEntityManager().find(Endereco.class, endereco.getEndereco().getId()));
                this.getEntityManager().lock(endereco.getEndereco(), LockModeType.NONE);

                
            }
            
            this.getEntityManager().persist(revendedor);
            this.getEntityManager().flush();
            
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
     * Lista todos os revendedores
     *
     * @return
     */
    public List<Revendedor> listar() {
        return this.getEntityManager().createNamedQuery("Revendedor.findAll", Revendedor.class).getResultList();
    }

    /**
     * Obtém um revendedor pelo ID
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

    public void apagar(Revendedor c) {
        Revendedor revendedor = this.getEntityManager().contains(c) ? c : this.getEntityManager().getReference(Revendedor.class, c.getId());
        ListIterator<RevendedorEndereco> end = revendedor.getEnderecos().listIterator();
        while (end.hasNext()) {
             this.getEntityManager().remove((RevendedorEndereco) end.next());
        }
        Usuario user = revendedor.getUsuario();
        
        this.getEntityManager().remove(revendedor);
        this.getEntityManager().remove(user);
    }
}
