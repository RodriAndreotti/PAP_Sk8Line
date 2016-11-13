/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor;

import br.com.sk8line.pessoa.revendedor.ejb.RevendedorRemote;
import br.com.sk8line.pessoa.revendedor.model.Revendedor;
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
@Named(value = "revendedorMB")
@RequestScoped
public class RevendedorMB {

    @EJB
    private RevendedorRemote ejb;
    private List<Revendedor> revendedores = new ArrayList();
    private Revendedor revendedor = new Revendedor();

    @PostConstruct
    public void init() {
        this.revendedores = ejb.listar();
    }

    public List<Revendedor> getRevendedores() {
        return revendedores;
    }

    public void setRevendedores(List<Revendedor> revendedores) {
        this.revendedores = revendedores;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public String editar(Revendedor revendedor) {
        this.revendedor = revendedor;
        return "/private/termo/editar.xhtml";
    }
    
    
    public String salvar(){
        this.ejb.salvar(this.revendedor);
        this.revendedor = new Revendedor();
        this.revendedores = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revendedor salvo com sucesso!", "Revendedor salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "";
    }
    
    
    public String apagar(Revendedor revendedor){
        this.ejb.apagar(revendedor);
        this.revendedores = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revendedor excluído com sucesso!", "Revendedor excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "";
    }
}
