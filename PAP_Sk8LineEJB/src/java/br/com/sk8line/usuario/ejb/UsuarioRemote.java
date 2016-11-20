/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.ejb;

import br.com.sk8line.usuario.model.Usuario;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */

@Remote
public interface UsuarioRemote{
    public Usuario doLogin(String login, String senha);
    public boolean existeLogin(String login);
    public Usuario getById(int id);
}
