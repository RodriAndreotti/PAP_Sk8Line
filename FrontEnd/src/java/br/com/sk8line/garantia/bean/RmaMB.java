/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.bean;

import br.com.sk8line.garantia.ejb.RmaRemote;
import br.com.sk8line.garantia.model.Rma;
import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.venda.model.Venda;
import br.com.sk8line.venda.model.VendaItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Named(value = "rmaMB")
@RequestScoped
public class RmaMB {

    @EJB
    private RmaRemote ejb;
    
    private List<Rma> rmas;
    private Rma rma = new Rma();
    private List<Produto> produtos;
    private Produto produto = new Produto();
    /**
     * Creates a new instance of RmaMB
     */
    public RmaMB() {
    }
    
    @PostConstruct
    private void init(){
        this.rmas = ejb.listar();
        this.resetAll();
        this.produtos = new ArrayList<>();
        if(this.rma.getVenda().getProdutos() != null){
            ListIterator it = this.rma.getVenda().getProdutos().listIterator();
            while(it.hasNext()){
                this.produtos.add(((VendaItem) it.next()).getProduto());
            }
        }
    }
    
    private void resetAll() {
        this.rma = new Rma();
        this.rma.setDataEntrada(new Date());
        this.rma.setVenda(new Venda());
        this.rma.setProduto(new Produto());
    }

    public List<Rma> getRmas() {
        return rmas;
    }

    public void setRmas(List<Rma> rmas) {
        this.rmas = rmas;
    }

    public Rma getRma() {
        return rma;
    }

    public void setRma(Rma rma) {
        this.rma = rma;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public RmaRemote getEjb() {
        return ejb;
    }

    public void setEjb(RmaRemote ejb) {
        this.ejb = ejb;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    
    /**
     * Carreva lista de pordutos no combo
     */
    public void onVendaChange() {
        ListIterator it = this.rma.getVenda().getProdutos().listIterator();
        while(it.hasNext()){
            this.produtos.add(((VendaItem) it.next()).getProduto());
        }
    }
    
    public String salvar(){
        rma.setProduto(this.produto);
        this.rma = this.ejb.salvar(rma);
        FacesMessage fm;
        if(this.rma != null){
            fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro ao salvar solicitação de garantia!", "Erro ao salvar solicitação de garantia!");
        }
        else {
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitação de garantia salva com sucesso!", "Solicitação de garantia salva com sucesso!");
        }
        
        this.rma = new Rma();
        this.rmas = this.ejb.listar();
        
        return "/private/rma/editar.xhtml";
    }
}
