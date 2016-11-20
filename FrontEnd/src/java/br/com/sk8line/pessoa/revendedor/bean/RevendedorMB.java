/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor.bean;

import br.com.sk8line.common.ejb.EnderecoRemote;
import br.com.sk8line.common.ejb.EstadoRemote;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.common.model.Estado;
import br.com.sk8line.common.service.CepWebService;
import br.com.sk8line.pessoa.revendedor.ejb.RevendedorRemote;
import br.com.sk8line.pessoa.revendedor.model.Revendedor;
import br.com.sk8line.pessoa.revendedor.model.RevendedorEndereco;
import br.com.sk8line.usuario.ejb.RoleRemote;
import br.com.sk8line.usuario.model.Usuario;
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
@Named(value = "revendedorMB")
@RequestScoped
public class RevendedorMB {

    @EJB
    private RevendedorRemote ejb;
    private List<Revendedor> revendedores;
    private Revendedor revendedor;
    private RevendedorEndereco endereco;

    @EJB
    private EstadoRemote ejbEstado;
    @EJB
    private EnderecoRemote ejbEndereco;
    @EJB
    private RoleRemote ejbRole;

    /**
     * Creates a new instance of RevendedorMB
     */
    public RevendedorMB() {
        resetAll();
    }

    @PostConstruct
    public void init() {
        this.revendedores = this.ejb.listar();
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

    public void addEndereco() {
        RevendedorEndereco end = new RevendedorEndereco();
        end.setRevendedor(this.revendedor);
        end.setEndereco(new Endereco());
        end.getEndereco().setEstado(new Estado());
        this.revendedor.getEnderecos().add(end);
    }


    public RevendedorEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(RevendedorEndereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Reinicializa a variável revendedor com um endereço e um usuário vazios
     */
    private void resetAll() {
        this.revendedor = new Revendedor();
        this.revendedor.setUsuario(new Usuario());
        RevendedorEndereco end = new RevendedorEndereco();
        end.setRevendedor(this.revendedor);
        end.setEndereco(new Endereco());
        end.getEndereco().setEstado(new Estado());
        this.revendedor.getEnderecos().add(end);
        

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
        this.revendedor.getEnderecos().get(i).setEndereco(endereco);
    }

    private Integer buscaIndexEndereco(Endereco endereco){
        ListIterator<RevendedorEndereco> i = this.revendedor.getEnderecos().listIterator();
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
        this.revendedor.getUsuario().setRole(this.ejbRole.getById(5));
        this.ejb.salvar(this.revendedor);
        this.revendedores = ejb.listar();
        resetAll();
        
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revendedor salvo com sucesso!", "Revendedor salvo com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
        return "/private/revendedor/listar.xhtml";
    }
    
    public String editar(Revendedor revendedor) {
        this.revendedor = revendedor;
        return "/private/revendedor/editar.xhtml";
    }
    
    public String confirm(Revendedor revendedor) {
        this.revendedor = revendedor;

        return "/private/revendedor/confirm.xhtml";
    }

    public String apagar(boolean confirm) {
        if (confirm) {
            FacesMessage fm;

            if (this.ejb.apagar(this.revendedor)) {
                this.revendedores = ejb.listar();
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Revendedor excluído com sucesso!", "Revendedor excluído com sucesso!");
            } else {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir revendedor!", "Erro ao excluir revendedor!");

            }
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

        
        this.revendedor = new Revendedor();

        return "/private/revendedor/listar.xhtml";
    }
}
