/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.session;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Wrapper que abstrai a sessão
 * Desenvolvido no padrão singleton (Só permite uma instância)
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class SessionContext {
    private static SessionContext instancia;

    public static SessionContext getInstancia() {
        if(instancia == null) {
            instancia = new SessionContext();
        }
        return instancia;
    }


    public SessionContext() {
    }

    private ExternalContext currentExternalContext(){
        if(FacesContext.getCurrentInstance() == null){
            throw new RuntimeException("Faces Conext usado fora de requisição HTTP");
        }
        else{
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }
    
    
    public void killSession(){
        currentExternalContext().invalidateSession();
    }
    
    public Object getAttr(String name) {
        return currentExternalContext().getSessionMap().get(name);
    }
    
    public void setAttr(String name, Object value){
        currentExternalContext().getSessionMap().put(name, value);
    }
}
