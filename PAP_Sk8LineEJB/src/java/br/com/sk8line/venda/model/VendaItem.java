package br.com.sk8line.venda.model;

import br.com.sk8line.produto.model.Produto;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda_produto")
public class VendaItem {
    @EmbeddedId
    private VendaPK PK;

    @ManyToOne
    @JoinColumn(name = "venda", nullable = false)
    private Venda venda;

    private Produto produto;

    private int quantidade;

    private double valorUnitario;

    private double desconto;

    private BigDecimal valorTotal;

    

    public void alterarQuantidade(int quantidade) {

    }

    public Venda getVenda() {
        return this.venda;
    }
}
