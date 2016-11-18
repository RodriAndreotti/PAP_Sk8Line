/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.bean;

import br.com.sk8line.usuario.ejb.RoleRemote;
import br.com.sk8line.usuario.model.Role;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Named(value = "roleMB")
@RequestScoped
public class RoleMB {

    @EJB
    private RoleRemote ejb;
    private List<Role> roles;
    
    @PostConstruct
    private void init(){
        this.roles = this.ejb.listar();
    }
    /**
     * Creates a new instance of RoleMB
     */
    public RoleMB() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    
}
