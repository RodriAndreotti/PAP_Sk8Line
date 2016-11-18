/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.pessoa.colaborador.model;

import br.com.sk8line.common.dao.EnderecoDAO;
import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.common.model.PessoaEndereco;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Entity
@Table(name="colaborador_endereco")
@IdClass(ColaboradorEnderecoPK.class)
public class ColaboradorEndereco extends PessoaEndereco implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @Id
    @ManyToOne
    @JoinColumn(name = "colaborador", referencedColumnName = "id_colaborador")
    private Colaborador colaborador;

    @Id
    private int numero;
    private String Complemento;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    @PrePersist
    private void loadReference(){
        this.setEndereco(EnderecoDAO.getInstance().loadReference(this.getEndereco()));
    }
    
}
