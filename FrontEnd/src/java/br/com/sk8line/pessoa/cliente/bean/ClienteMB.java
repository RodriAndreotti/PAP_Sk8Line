/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.cliente.bean;

import br.com.sk8line.pessoa.ejb.ClienteRemote;
import br.com.sk8line.pessoa.cliente.model.ClientePessoaFisica;
import br.com.sk8line.pessoa.cliente.model.ClientePessoaJuridica;
import br.com.sk8line.pessoa.model.Pessoa;
import br.com.sk8line.pessoa.model.PessoaFisica;
import br.com.sk8line.pessoa.model.PessoaJuridica;
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
@Named(value = "pessoaMB")
@RequestScoped
public class ClienteMB {

    @EJB
    private ClienteRemote ejb;
    private List<Pessoa> pessoas = new ArrayList();
    private Pessoa pessoaFisica = new ClientePessoaFisica();
    private Pessoa pessoaJuridica  = new ClientePessoaJuridica();

    @PostConstruct
    public void init() {
        this.pessoas = ejb.listar();
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }

    public Pessoa getPessoaFisica() {
        return pessoaFisica;
    }
    
    public Pessoa getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaFisica(Pessoa pessoa) {
        this.pessoaFisica = pessoa;
    }
    
     public void setPessoaJuridica(Pessoa pessoa) {
        this.pessoaJuridica = pessoa;
    }

    public String editarPessoaFisica(Pessoa pessoa) {
        this.pessoaFisica = pessoa;
        return "/private/cliente/editar.xhtml";
    }

    public String editarPessoaJuridica(Pessoa pessoa) {
        this.pessoaFisica = pessoa;
        return "/private/cliente/editar.xhtml";
    }
    
    public String salvarPessoaFisica() {
        this.ejb.salvar(this.pessoaFisica);
        this.pessoaFisica = new PessoaFisica();
        this.pessoas = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!", "Cliente salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/cliente/listar.xhtml";
    }
    
     public String salvarPessoaJuridica() {
        this.ejb.salvar(this.pessoaJuridica);
        this.pessoaJuridica = new PessoaJuridica();
        this.pessoas = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!", "Cliente salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/cliente/listar.xhtml";
    }

    public String apagarPessoaFisica(Pessoa pessoa) {
        this.ejb.apagar(pessoa);
        this.pessoas = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluído com sucesso!", "Cliente excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/cliente/listar.xhtml";
    }
    
    public String apagarPessoaJuridica(Pessoa pessoa) {
        this.ejb.apagar(pessoa);
        this.pessoas = ejb.listar();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluído com sucesso!", "Cliente excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "/private/cliente/listar.xhtml";
    }
}
