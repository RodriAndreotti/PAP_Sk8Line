package br.com.sk8line.common.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {

    @Id
    @Column(name="id_estado")
    private int id;

    private String uf;

    private String nome;

}
