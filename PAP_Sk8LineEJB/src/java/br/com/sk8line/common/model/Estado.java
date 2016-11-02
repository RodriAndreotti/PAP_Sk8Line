package br.com.sk8line.common.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "UFSEQ", allocationSize = 1)
public class Estado implements Serializable {

    @Id
    @Column(name="id_estado")
    @GeneratedValue(generator = "UFSEQ", strategy = GenerationType.IDENTITY)
    private int id;

    private String uf;

    private String nome;

}
