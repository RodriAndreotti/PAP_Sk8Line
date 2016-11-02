package br.com.sk8line.garantia.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "termo_garantia")
@SequenceGenerator(name = "SEQ_GARANTIA", allocationSize = 1)
public class TermoGarantia {

    @Id
    @Column(name = "id_termo_garantia")
    @GeneratedValue(generator = "SEQ_GARANTIA", strategy = GenerationType.IDENTITY)
    private int id;

    private int periodo;

    private String termo;

    public void cadastrar() {

    }

}
