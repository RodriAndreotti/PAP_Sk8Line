/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.usuario.util;

import br.com.sk8line.usuario.ejb.UsuarioRemote;
import br.com.sk8line.usuario.model.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
public class UserConverter implements Converter {

    @EJB
    private UsuarioRemote ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null) {
            return null;
        }
        
        if(value.equals("") || value.equals("0")){
            return value;
        }
        int id = Integer.parseInt(value);
        return findUser(id);
        }
        catch(NumberFormatException ex) {
            return value;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof Usuario) || value == null){
            return null;
        }
        
        Integer id = ((Usuario) value).getId();
        
        return String.valueOf(id);
    }

    private Usuario findUser(int id) {
        return this.ejb.getById(id);
    }
}
