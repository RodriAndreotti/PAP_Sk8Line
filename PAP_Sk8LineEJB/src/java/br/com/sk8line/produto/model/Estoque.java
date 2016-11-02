package br.com.sk8line.produto.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "EstoqueSEQ", allocationSize = 1)
public class Estoque {

    @Id
    @GeneratedValue(generator = "EstoqueSEQ", strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(referencedColumnName = "id", name = "produto")
    private Produto produto;

    private int quantidade;

    private Calendar ultimaAtualizacao;

    public boolean inserirEstoque(Produto produto) {
        return false;
    }

    public void retirarDoEstoque(Produto produto, int quantidade) {

    }

}
