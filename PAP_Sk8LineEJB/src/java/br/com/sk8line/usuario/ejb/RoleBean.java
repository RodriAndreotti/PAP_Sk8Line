/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.usuario.ejb;

import br.com.sk8line.usuario.dao.RoleDAO;
import br.com.sk8line.usuario.model.Role;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Integração com ROLE
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Stateless
public class RoleBean implements RoleRemote{

    @Override
    public List<Role> listar() {
        return RoleDAO.getInstance().listar();
    }

    @Override
    public Role getById(int id) {
        return RoleDAO.getInstance().getById(id);
    }
    
}
