/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.ejb;

import br.com.sk8line.usuario.model.Role;
import java.util.List;
import javax.ejb.Remote;

/**
 * Interface remota para os roles
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Remote
public interface RoleRemote {
    public List<Role> listar();
    public Role getById(int id);
}
