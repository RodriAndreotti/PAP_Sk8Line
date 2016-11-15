/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.util;

import br.com.sk8line.produto.ejb.ProdutoRemote;
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
public class ProdutoConverter implements Converter {

    @EJB
    private ProdutoRemote ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int id = Integer.parseInt(value);
        return findProduto(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(!(value instanceof Produto)){
            return null;
        }
        
        Integer id = ((Produto) value).getId();
        
        return String.valueOf(id);
    }

    private Produto findProduto(int id) {
        return this.ejb.getById(id);
    }
}
