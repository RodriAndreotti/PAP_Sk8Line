/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.dao;

import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.usuario.service.Password;
import javax.persistence.EntityManager;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class UsuarioDAO {

    private EntityManager em;

    /**
     * Realiza o login no banco de dados
     * @param login
     * @param senha
     * @return 
     */
    public Usuario doLogin(String login, String senha) {

        if (this.existeUsuario(login)) {
            String salt = this.obterSalt(login);

            Password passwd = new Password(salt);

            String hash = passwd.encrypt(senha);

            // SELECT * FROM usuario WHERE login = login AND senha = hash AND ativo = 1
            return new Usuario();
        }

        return null;

    }

    /**
     * Verifica se o usuário existe no banco de dados
     * @param login
     * @return 
     */
    private boolean existeUsuario(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Obtém o salt para o usuário
     * @param login
     * @return 
     */
    private String obterSalt(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
