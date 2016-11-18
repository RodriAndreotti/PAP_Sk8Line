/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.util;

import br.com.sk8line.garantia.ejb.TermoRemote;
import br.com.sk8line.garantia.model.TermoGarantia;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
public class TermoConverter implements Converter {

    @EJB
    private TermoRemote ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null) {
            return null;
        }
        
        if(value.equals("") || value.equals("0")){
            return value;
        }
        int id = Integer.parseInt(value);
        return findTermo(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof TermoGarantia)){
            return null;
        }
        
        Integer id = ((TermoGarantia) value).getId();
        
        return String.valueOf(id);
    }

    private TermoGarantia findTermo(int id) {
        return this.ejb.getById(id);
    }
}
