package br.com.sk8line.garantia.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TermoGarantia {

    @Id
    @Column(name = "id_termo_garantia")
    private int id;

    private int periodo;

    private String termo;

    public void cadastrar() {

    }

}
