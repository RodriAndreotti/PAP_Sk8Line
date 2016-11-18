/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.colaborador.bean;

import br.com.sk8line.common.ejb.EnderecoRemote;
import br.com.sk8line.common.ejb.EstadoRemote;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.common.model.Estado;
import br.com.sk8line.common.model.PessoaEndereco;
import br.com.sk8line.common.service.CepWebService;
import br.com.sk8line.pessoa.colaborador.ejb.ColaboradorRemote;
import br.com.sk8line.pessoa.colaborador.model.Colaborador;
import br.com.sk8line.pessoa.colaborador.model.ColaboradorEndereco;
import br.com.sk8line.usuario.model.Usuario;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Named(value = "colaboradorMB")
@RequestScoped
public class ColaboradorMB {

    @EJB
    private ColaboradorRemote ejb;
    private List<Colaborador> colaboradores;
    private Colaborador colaborador;
    private ColaboradorEndereco endereco;

    @EJB
    private EstadoRemote ejbEstado;
    @EJB
    private EnderecoRemote ejbEndereco;

    /**
     * Creates a new instance of ColaboradorMB
     */
    public ColaboradorMB() {
        resetAll();
    }

    @PostConstruct
    public void init() {
        this.colaboradores = this.ejb.listar();
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public void addEndereco() {
        ColaboradorEndereco end = new ColaboradorEndereco();
        end.setColaborador(this.colaborador);
        end.setEndereco(new Endereco());
        end.getEndereco().setEstado(new Estado());
        this.colaborador.getEnderecos().add(end);
    }


    public ColaboradorEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(ColaboradorEndereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Reinicializa a variável colaborador com um endereço e um usuário vazios
     */
    private void resetAll() {
        this.colaborador = new Colaborador();
        this.colaborador.setUsuario(new Usuario());
        ColaboradorEndereco end = new ColaboradorEndereco();
        end.setColaborador(this.colaborador);
        end.setEndereco(new Endereco());
        end.getEndereco().setEstado(new Estado());
        this.colaborador.getEnderecos().add(end);
        

        this.endereco = end;
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
        this.colaborador.getEnderecos().get(i).setEndereco(endereco);
    }

    private Integer buscaIndexEndereco(Endereco endereco){
        ListIterator<ColaboradorEndereco> i = this.colaborador.getEnderecos().listIterator();
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
        this.ejb.salvar(this.colaborador);
        this.colaboradores = ejb.listar();
        resetAll();
        
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Colaborador salvo com sucesso!", "Colaborador salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
        return "/private/colaborador/listar.xhtml";
    }
    
    public String editar(Colaborador colaborador) {
        this.colaborador = colaborador;
        return "/private/colaborador/editar.xhtml";
    }
    
    public String confirm(Colaborador colaborador) {
        this.colaborador = colaborador;

        return "/private/colaborador/confirm.xhtml";
    }

    public String apagar(boolean confirm) {
        if (confirm) {
            FacesMessage fm;

            if (this.ejb.apagar(this.colaborador)) {
                this.colaboradores = ejb.listar();
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Colaborador excluído com sucesso!", "Colaborador excluído com sucesso!");
            } else {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir colaborador!", "Erro ao excluir colaborador!");

            }
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

        
        this.colaborador = new Colaborador();

        return "/private/colaborador/listar.xhtml";
    }
}
