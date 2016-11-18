/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.util;

import br.com.sk8line.produto.ejb.EstoqueRemote;
import br.com.sk8line.produto.model.Estoque;
import br.com.sk8line.produto.model.Produto;
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
public class EstoqueConverter implements Converter {

    @EJB
    private EstoqueRemote ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null) {
            return null;
        }
        
        if(value.equals("") || value.equals("0")){
            return value;
        }
        int id = Integer.parseInt(value);
        return findEstoque(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof Estoque)){
            return null;
        }
        
        Integer id = ((Estoque) value).getId();
        
        return String.valueOf(id);
    }

    private Estoque findEstoque(int id) {
        return this.ejb.getById(id);
    }
}
