/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.common.util;

import br.com.sk8line.common.ejb.EstadoRemote;
import br.com.sk8line.common.model.Estado;
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
public class EstadoConverter implements Converter {

    @EJB
    private EstadoRemote ejb;

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
        return findEstado(id);
        }
        catch (NumberFormatException ex) {
            return value;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof Estado) || value == null){
            return null;
        }
        
        Integer id = ((Estado) value).getId();
        
        return String.valueOf(id);
    }

    private Estado findEstado(int id) {
        return this.ejb.getById(id);
    }
}
