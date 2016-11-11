/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.bean;


import br.com.sk8line.garantia.dao.ejb.TermoRemote;
import br.com.sk8line.garantia.model.TermoGarantia;
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
 * @author Rodrigo
 */
@Named(value = "termoMB")
@RequestScoped
public class TermoMB {

    @EJB
    private TermoRemote ejb;
    private List<TermoGarantia> termos = new ArrayList();
    private TermoGarantia termo = new TermoGarantia();

    @PostConstruct
    public void init() {
        this.termos = ejb.listar();
    }

    public List<TermoGarantia> getTermos() {
        return termos;
    }

    public void setTermos(List<TermoGarantia> termos) {
        this.termos = termos;
    }

    public TermoGarantia getTermo() {
        return termo;
    }

    public void setTermo(TermoGarantia termo) {
        this.termo = termo;
    }

    public String editar(TermoGarantia termo) {
        this.termo = termo;
        return "/private/termo/editar.xhtml";
    }
    
    
    public String salvar(){
        this.ejb.salvar(this.termo);
        this.termo = new TermoGarantia();
        this.termos = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Termo salvo com sucesso!", "Termo salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/termo/listar.xhtml";
    }
    
    
    public String apagar(TermoGarantia termo){
        this.ejb.apagar(termo);
        this.termos = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Termo excluído com sucesso!", "Termo excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/termo/listar.xhtml";
    }
}