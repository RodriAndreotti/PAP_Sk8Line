/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.bean;

import br.com.sk8line.produto.ejb.EstoqueRemote;
import br.com.sk8line.produto.model.Estoque;
import br.com.sk8line.produto.model.Produto;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@Named(value = "estoqueMB")
@RequestScoped
public class EstoqueMB {

    @EJB
    private EstoqueRemote ejb;
    private Estoque estoque;
    private int qtd;

    /**
     * Creates a new instance of EstoqueMB
     */
    public EstoqueMB() {
    }

    public String inserirEstoque() {
        FacesMessage fm;

        if (this.ejb.inserirEstoque(this.estoque, this.qtd)) {
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Estoque inserido com sucesso!", "Estoque inserido com sucesso!");
        } else {
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Houve um erro ao inserir o estoque!", "Houve um erro ao inserir o estoque!");
        }
        this.estoque = null;
        FacesContext.getCurrentInstance().addMessage(null, fm);

        return "/private/produto/listar.xhtml";
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String lancar(Produto produto) {
        this.estoque = produto.getEstoque();

        return "/private/produto/insereEstoque.xhtml";
    }
}
