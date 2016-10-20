package br.com.sk8line.venda.model;



import br.com.sk8line.produto.model.Produto;
import java.math.BigDecimal;


public class VendaItem {

    private Produto produto;

    private int quantidade;

    private double valorUnitario;

    private double desconto;

    private BigDecimal valorTotal;

    public void alterarQuantidade(int quantidade) {

    }

}
