/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.usuario.model.Usuario_;
import br.com.sk8line.usuario.service.Password;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class UsuarioDAO extends DAO {

    /**
     * Realiza o email no banco de dados
     *
     * @param email
     * @param senha
     * @return
     */
    public Usuario doLogin(String email, String senha) {

        if (this.existeUsuario(email)) {
            String salt = this.obterSalt(email);

            Password passwd = new Password(salt);

            String hash = passwd.encrypt(senha);

            // SELECT * FROM usuario WHERE email = email AND senha = hash AND ativo = 1
            return new Usuario();
        }

        return null;

    }

    /**
     * Verifica se o usuário existe no banco de dados
     *
     * @param email
     * @return
     */
    public boolean existeUsuario(String email) {
        CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> user = cq.from(Usuario.class);
        
        TypedQuery<Usuario> typedQuery = this.getEntityManager().createQuery(
                cq.select(user)
                .where(cb.like(user.<String>get("email"), email))
        );
        

        List<Usuario> results = typedQuery.getResultList();

        return !results.isEmpty();
    }

    /**
     * Obtém o salt para o usuário
     *
     * @param login
     * @return
     */
    private String obterSalt(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
