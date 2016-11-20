/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.cliente.bean;

import br.com.sk8line.common.ejb.EnderecoRemote;
import br.com.sk8line.common.ejb.EstadoRemote;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.common.model.Estado;
import br.com.sk8line.common.service.CepWebService;
import br.com.sk8line.pessoa.cliente.model.ClientePFEndereco;
import br.com.sk8line.pessoa.cliente.ejb.ClienteRemote;
import br.com.sk8line.pessoa.cliente.model.ClientePessoaFisica;
import br.com.sk8line.usuario.ejb.RoleRemote;
import br.com.sk8line.usuario.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
@Named(value = "clienteMB")
@RequestScoped
public class ClienteMB {

    @EJB
    private ClienteRemote ejb;
    private List<ClientePessoaFisica> clientes = new ArrayList();
    private ClientePessoaFisica cliente = new ClientePessoaFisica();
    
    @EJB
    private EstadoRemote ejbEstado;
    @EJB
    private EnderecoRemote ejbEndereco;
    @EJB
    private RoleRemote ejbRole;

    @PostConstruct
    public void init() {
        this.clientes = ejb.listar();
        resetAll();
    }

    public List<ClientePessoaFisica> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClientePessoaFisica> clientes) {
        this.clientes = clientes;
    }

    public ClientePessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(ClientePessoaFisica cliente) {
        this.cliente = cliente;
    }


    
    
     /**
     * Reinicializa a variável cliente com um endereço e um usuário vazios
     */
    private void resetAll() {
        this.cliente = new ClientePessoaFisica();
        this.cliente.setUsuario(new Usuario());
        ClientePFEndereco end = new ClientePFEndereco();
        end.setCliente(this.cliente);
        end.setEndereco(new Endereco());
        end.getEndereco().setEstado(new Estado());
        this.cliente.getEnderecos().add(end);
        
    }

    /**
     * Busca o endereço pelo CEP fazendo uso do webservice
     *
     * @param endereco
     */
    public void buscaCep(Endereco endereco) {
        int i = this.buscaIndexEndereco(endereco);
        String cep = endereco.getCep();
        endereco = this.ejbEndereco.getByCep(endereco.getCep());
        if(endereco == null){
            CepWebService service = new CepWebService(ejbEstado);
            endereco = service.getEnderecoByCep(cep);
            if(endereco != null){
                endereco = this.ejbEndereco.inserir(endereco);
            }
        }
        this.cliente.getEnderecos().get(i).setEndereco(endereco);
    }

    private Integer buscaIndexEndereco(Endereco endereco){
        ListIterator<ClientePFEndereco> i = this.cliente.getEnderecos().listIterator();
        while(i.hasNext()){
            int index = i.nextIndex();
            Endereco end = i.next().getEndereco();
            if(endereco.equals(end)){
                return index;
            }
        }
        return null;
    }
    
    public String salvar(){
        this.cliente.getUsuario().setRole(this.ejbRole.getById(6));
        this.ejb.salvar(this.cliente);
        this.clientes = ejb.listar();
        resetAll();
        
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revendedor salvo com sucesso!", "Revendedor salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
        return "/private/cliente/listar.xhtml";
    }
    
    public String editar(ClientePessoaFisica cliente) {
        this.cliente = cliente;
        return "/private/cliente/editar.xhtml";
    }
    
    public String confirm(ClientePessoaFisica cliente) {
        this.cliente = cliente;

        return "/private/cliente/confirm.xhtml";
    }

    public String apagar(boolean confirm) {
        if (confirm) {
            FacesMessage fm;

            if (this.ejb.apagar(this.cliente)) {
                this.clientes = ejb.listar();
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revendedor excluído com sucesso!", "Revendedor excluído com sucesso!");
            } else {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir cliente!", "Erro ao excluir cliente!");

            }
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

        
        this.cliente = new ClientePessoaFisica();

        return "/private/cliente/listar.xhtml";
    }
}
