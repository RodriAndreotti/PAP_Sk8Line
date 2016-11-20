/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.venda.util;

import br.com.sk8line.venda.ejb.VendaRemote;
import br.com.sk8line.venda.model.Venda;
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
public class VendaConverter implements Converter {

    @EJB
    private VendaRemote ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if (value == null) {
                return null;
            }

            if (value.equals("") || value.equals("0")) {
                return value;
            }
            int id = Integer.parseInt(value);
            return findVenda(id);
        } catch (NumberFormatException ex) {
            return value;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Venda)) {
            return null;
        }

        Integer id = ((Venda) value).getId();

        return String.valueOf(id);
    }

    private Venda findVenda(int id) {
        return this.ejb.getById(id);
    }
}
