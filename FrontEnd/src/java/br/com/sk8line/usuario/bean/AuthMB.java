/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.bean;

import br.com.sk8line.usuario.ejb.UsuarioRemote;
import br.com.sk8line.usuario.model.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import br.com.sk8line.session.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@ManagedBean
@SessionScoped
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
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login realizado com sucesso!", "Login realizado com sucesso!");
                SessionContext.getInstancia().setAttr("usuario", usuario);
                FacesContext.getCurrentInstance().addMessage(null, fm);
                return "/private/index";
            } else {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e/ou senha inválidos!", "Usuário e/ou senha inválidos!");
            }
        } else {
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o usuário e a senha", "Informe o usuário e a senha");

        }

        FacesContext.getCurrentInstance().addMessage(null, fm);

        return "/";
    }
    
    public String doLogoff() {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Logoff realizado com sucesso!", "Logoff realizado com sucesso!");
        
        SessionContext.getInstancia().killSession();
        
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "login";
    }

}
