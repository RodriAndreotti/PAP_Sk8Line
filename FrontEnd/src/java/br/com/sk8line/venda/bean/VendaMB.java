/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.venda.bean;

import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.session.SessionContext;
import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.venda.ejb.VendaRemote;
import br.com.sk8line.venda.model.Venda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author leonardo.lima
 */
@Named(value = "vendaMB")
@javax.enterprise.context.SessionScoped
public class VendaMB implements Serializable{

    private static final long serialVersionUID = 356487999802820675L;

    @EJB
    private VendaRemote ejb;
    private List<Venda> vendas = new ArrayList();
    private Venda venda = new Venda();

    private Produto produto = new Produto();
    private int qtd = 0;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    

    public String editar(Venda venda) {
        this.venda = venda;
        return "/private/venda/editar.xhtml";
    }

    public String inserirProduto() {
        if (this.venda == null) {
            this.venda = new Venda();
        }

        if (this.venda.getVendedor() == null) {
            this.venda.setVendedor((Usuario) SessionContext.getInstancia().getAttr("usuario"));
        }
        this.venda.adicionarProduto(this.produto, this.qtd);

        return "";
    }
    
    public void recalculate(){
        this.venda.recalcular();
    }

    public String salvar() {
        this.venda.setVendedor((Usuario) SessionContext.getInstancia().getAttr("usuario"));
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
