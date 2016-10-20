package br.com.sk8line.usuario.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    private int id;

    private String nome;

}
