/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.cliente.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.pessoa.cliente.model.ClientePFEndereco;
import br.com.sk8line.pessoa.cliente.model.ClientePessoaFisica;
import br.com.sk8line.usuario.model.Usuario;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.LockModeType;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Rodrigo
 */
public class ClienteDAO extends DAO {

    private static ClienteDAO instance;

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }

        return instance;
    }


    /**
     * Salva o ClientePessoaFisica
     * @param revendedor
     * @return 
     */
    public ClientePessoaFisica salvar(ClientePessoaFisica revendedor) {
        
        if (revendedor.getId() == null) {
           
            
            ListIterator<ClientePFEndereco> end = revendedor.getEnderecos().listIterator();
            while (end.hasNext()) {
                ClientePFEndereco endereco = (ClientePFEndereco) end.next();
                endereco.setEndereco(this.getEntityManager().find(Endereco.class, endereco.getEndereco().getId()));
                this.getEntityManager().lock(endereco.getEndereco(), LockModeType.NONE);

                
            }
            
            this.getEntityManager().persist(revendedor);
            this.getEntityManager().flush();
            
        } else {
            if (!this.getEntityManager().contains(revendedor)) {
                if (this.getEntityManager().find(ClientePessoaFisica.class, revendedor.getId()) == null) {
                    throw new NotFoundException("Cliente não encontrado");
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
    public List<ClientePessoaFisica> listar() {
        return this.getEntityManager().createNamedQuery("Cliente.findAll", ClientePessoaFisica.class).getResultList();
    }

    /**
     * Obtém um revendedor pelo ID
     *
     * @param id
     * @return
     */
    public ClientePessoaFisica getById(int id) {
        ClientePessoaFisica revendedor = this.getEntityManager().find(ClientePessoaFisica.class, id);
        if (revendedor == null) {
            throw new NotFoundException("Cliente não encontrado");
        }

        return revendedor;
    }

    public void apagar(ClientePessoaFisica c) {
        ClientePessoaFisica revendedor = this.getEntityManager().contains(c) ? c : this.getEntityManager().getReference(ClientePessoaFisica.class, c.getId());
        ListIterator<ClientePFEndereco> end = revendedor.getEnderecos().listIterator();
        while (end.hasNext()) {
             this.getEntityManager().remove((ClientePFEndereco) end.next());
        }
        Usuario user = revendedor.getUsuario();
        
        this.getEntityManager().remove(revendedor);
        this.getEntityManager().remove(user);
    }
}
