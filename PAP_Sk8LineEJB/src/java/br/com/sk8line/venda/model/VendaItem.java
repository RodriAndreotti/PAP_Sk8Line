package br.com.sk8line.venda.model;

import br.com.sk8line.produto.model.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda_produto")
@IdClass(VendaPK.class)
public class VendaItem implements Serializable {

    
    private static final long serialVersionUID = 4092125695623809085L;
    
    @ManyToOne
    @Id
    @JoinColumn(name="venda", referencedColumnName = "id_venda")
    private Venda venda;

    @OneToOne
    @Id
    @JoinColumn(name = "produto",referencedColumnName = "id_produto")
    private Produto produto;

    private int quantidade;

    @Column(name="val_unit")
    private double valorUnitario;

    private double desconto;

    @Column(name="val_total")
    private BigDecimal valorTotal;

    

    public void alterarQuantidade(int quantidade) {

    }

    public Venda getVenda() {
        return this.venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.venda);
        hash = 13 * hash + Objects.hashCode(this.produto);
        hash = 13 * hash + this.quantidade;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.valorUnitario) ^ (Double.doubleToLongBits(this.valorUnitario) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.desconto) ^ (Double.doubleToLongBits(this.desconto) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.valorTotal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaItem other = (VendaItem) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorUnitario) != Double.doubleToLongBits(other.valorUnitario)) {
            return false;
        }
        if (Double.doubleToLongBits(this.desconto) != Double.doubleToLongBits(other.desconto)) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

    
}
