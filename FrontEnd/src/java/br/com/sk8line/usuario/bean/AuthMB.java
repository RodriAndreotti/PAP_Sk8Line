/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.bean;

import br.com.sk8line.usuario.ejb.UsuarioRemote;
import br.com.sk8line.usuario.model.Usuario;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Named(value = "authMB")
@RequestScoped
public class AuthMB {

    @EJB
    UsuarioRemote ejb;
    private String email = new String();
    private String senha = new String();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String doLogin() {
        FacesMessage fm;
        if (this.getEmail() != null && this.getSenha() != null) {
            Usuario usuario = ejb.doLogin(this.getEmail(), this.getSenha());
            if (usuario != null) {
                fm = new FacesMessage("Login realizado com sucesso!");
            } else {
                fm = new FacesMessage("Usuário e/ou senha inválidos!");
            }
        } else {
            fm = new FacesMessage("Informe o usuário e a senha");

        }

        FacesContext.getCurrentInstance().addMessage("msg", fm);
        FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(this.getEmail()));

        return "";
    }

}
