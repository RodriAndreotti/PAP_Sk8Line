package br.com.sk8line.produto.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estoque {

    @Id
    private int id;

    private Produto produto;

    private int quantidade;

    private Calendar ultimaAtualizacao;

    public boolean inserirEstoque(Produto produto) {
        return false;
    }

    public void retirarDoEstoque(Produto produto, int quantidade) {

    }

}
