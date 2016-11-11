package br.com.sk8line.garantia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "termo_garantia")
@SequenceGenerator(name = "SEQGARANTIA", allocationSize = 1)
public class TermoGarantia implements Serializable{

    
    
    @Id
    @Column(name = "id_termo_garantia")
    @GeneratedValue(generator = "SEQGARANTIA", strategy = GenerationType.IDENTITY)
    private int id;

    private int periodo;

    private String termos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getTermos() {
        return termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }

}
