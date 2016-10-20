package br.com.sk8line.produto.model;



import br.com.sk8line.garantia.model.TermoGarantia;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto implements CadastroProduto {

    @Id
    private int id;

    private String nome;

    private String descricao;

    private TermoGarantia termoGarantia;

    private double largura;

    private double altura;

    private double comprimento;

    private double valor;

    public void cadastrar() {

    }

    public void editar() {

    }

    public void apagar() {

    }

    public void alterarPreco() {

    }

}
