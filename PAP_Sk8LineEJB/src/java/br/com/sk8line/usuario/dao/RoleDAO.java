/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.usuario.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.usuario.model.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;

/**
 * Abstrai a persistência a dados do módulo de ROLES
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class RoleDAO extends DAO{
    private static RoleDAO instance;
    
    public static RoleDAO getInstance(){
        if(instance == null) {
            instance = new RoleDAO();
        }
        
        return instance;
    }
    
    private RoleDAO(){}
    /**
     * Retorna todos os Roles
     * @return 
     */
    public List<Role> listar(){
        EntityManager em = this.getEntityManager();
        TypedQuery query = em.createQuery("SELECT r FROM Role r", Role.class);
        return query.getResultList();
    }
    
    /**
     * Obtém o Role por ID
     * @param id
     * @return 
     */
    public Role getById(int id){
        Role role = this.getEntityManager().find(Role.class, id);
        if (role == null) {
            throw new NotFoundException("Role não encontrado");
        }
        
        return role;
    }
}
