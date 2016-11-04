/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.ejb;

import br.com.sk8line.usuario.dao.UsuarioDAO;
import br.com.sk8line.usuario.model.Usuario;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Stateless
public class UsuarioBean implements UsuarioRemote {

    
    private final UsuarioDAO dao = new UsuarioDAO();

    @Override
    public Usuario doLogin(String login, String senha) {

        return this.dao.doLogin(login, senha);
    }

    @Override
    public boolean existeLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
