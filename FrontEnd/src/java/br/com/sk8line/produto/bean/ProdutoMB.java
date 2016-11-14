/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.bean;

import br.com.sk8line.produto.ejb.ProdutoRemote;
import br.com.sk8line.produto.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@Named(value = "produtoMB")
@RequestScoped
public class ProdutoMB {

    @EJB
    private ProdutoRemote ejb;
    private List<Produto> produtos = new ArrayList();
    private Produto produto = new Produto();

    @PostConstruct
    public void init() {
        this.produtos = ejb.listar();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String editar(Produto produto) {
        this.produto = produto;
        return "/private/produto/editar.xhtml";
    }

    public String salvar() {
        this.ejb.salvar(this.produto);
        this.produto = new Produto();
        this.produtos = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", "Produto salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/produto/listar.xhtml";
    }

    public String confirm(Produto produto) {
        this.produto = produto;

        return "/private/produto/confirm.xhtml";
    }

    public String apagar(boolean confirm) {
        if (confirm) {
            
            this.ejb.apagar(this.produto);
            this.produtos = ejb.listar();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto excluído com sucesso!", "Produto excluído com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } 
        
        this.produto = new Produto();
        
        return "/private/produto/listar.xhtml";
    }
}
