/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.venda.bean;

import br.com.sk8line.venda.ejb.VendaRemote;
import br.com.sk8line.venda.model.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author leonardo.lima
 */
@Named(value = "vendaMB")
@RequestScoped
public class VendaMB {

    @EJB
    private VendaRemote ejb;
    private List<Venda> vendas = new ArrayList();
    private Venda venda = new Venda();
    
    
    @PostConstruct
    public void init() {
        this.vendas = ejb.listar();
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String editar(Venda venda) {
        this.venda = venda;
        return "/private/venda/editar.xhtml";
    }

    public String salvar() {
        this.ejb.salvar(this.venda);
        this.venda = new Venda();
        this.vendas = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venda salva com sucesso!", "Venda salva com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/venda/listar.xhtml";
    }

    public String apagar(Venda venda) {
        this.ejb.apagar(venda);
        this.vendas = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venda excluída com sucesso!", "Venda excluída com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/venda/listar.xhtml";
    }
}
