/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.common.bean;

import br.com.sk8line.common.ejb.EstadoRemote;
import br.com.sk8line.common.model.Estado;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Named(value = "estadoMB")
@RequestScoped
public class EstadoMB {

    @EJB
    private EstadoRemote ejb;
    private List<br.com.sk8line.common.model.Estado> estados;
    
    @PostConstruct
    public void init(){
        this.estados = this.ejb.listar();
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
