/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.usuario.service.Password;
import javax.persistence.NoResultException;
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
            String salt;
            salt = this.obterSalt(email);

            Password passwd = new Password(salt);

            String hash = passwd.encrypt(senha);

            // Realiza a consulta
            Usuario usuario;

            CriteriaBuilder builder = this.getCriteriaBuilder();
            CriteriaQuery<Usuario> userQuery = builder.createQuery(Usuario.class);
            Root<Usuario> user = userQuery.from(Usuario.class);

            try {

                TypedQuery<Usuario> typedQuery = this.getEntityManager().createQuery(
                        userQuery
                                .where(
                                        builder.like(user.<String>get("email"), email),
                                        builder.like(user.<String>get("senha"), hash)
                                )
                );

                usuario = typedQuery.getSingleResult();
            } catch (NoResultException ex) {
                usuario = null;
            }

            return usuario;

            // SELECT * FROM usuario WHERE email = email AND senha = hash AND ativo = 1
            /* return new Usuario(); */
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
        long count = 0l;
        CriteriaBuilder builder = this.getCriteriaBuilder();

        CriteriaQuery<Long> cnt = builder.createQuery(Long.class);
        Root<?> root = cnt.from(Usuario.class);
        Root<Usuario> user = cnt.from(Usuario.class);

        cnt.select(builder.count(root));

        TypedQuery<Long> typedQuery = this.getEntityManager().createQuery(
                cnt.select(builder.count(root))
                        .where(builder.like(user.<String>get("email"), email))
        );

        count = typedQuery.getSingleResult();

        return count > 0;
    }

    /**
     * Obtém o salt para o usuário
     *
     * @param login
     * @return
     */
    private String obterSalt(String email) {

        //throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
        CriteriaBuilder builder = this.getCriteriaBuilder();
        CriteriaQuery<String> saltQuery = builder.createQuery(String.class);

        Root<?> root = saltQuery.from(Usuario.class);

        TypedQuery<String> typedQuery = this.getEntityManager().createQuery(
                saltQuery.select(root.get("salt").as(String.class))
                        .where(builder.like(root.<String>get("email"), email))
        );
        String salt = typedQuery.getSingleResult();

        return salt;
    }
}
