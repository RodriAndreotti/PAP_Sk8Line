package br.com.sk8line.venda.model;

import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.usuario.model.Usuario;
import br.com.sk8line.venda.util.Situacao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Venda")
@NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")
public class Venda implements Serializable {

    private static final long serialVersionUID = 7956105378025276536L;

    public Venda() {
        this.dataVenda = new Date();
        // this.vendedor = new Usuario();
        // this.cliente = new Usuario();
        // this.produtos = new ArrayList<>();
    }

    

    @Id
    @Column(name = "id_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "vendedor", referencedColumnName = "id_usuario")
    private Usuario vendedor;

    @OneToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id_usuario")
    private Usuario cliente;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    private double desconto;

    @Column(name = "valor_liquido")
    private BigDecimal valorLiquido;

    private boolean concretizada;

    @Enumerated(EnumType.ORDINAL)
    private Situacao situacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_venda")
    private Date dataVenda;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda", fetch = FetchType.EAGER)
    private List<VendaItem> produtos;

    public void adicionarProduto(Produto produto, int qtd) {
        if(this.produtos == null){
            this.produtos = new ArrayList();
        }
        
        VendaItem item = new VendaItem();
        item.setDesconto(0);
        item.setProduto(produto);
        item.setQuantidade(qtd);
        item.setValorUnitario(produto.getValor());
        BigDecimal valor = new BigDecimal(produto.getValor());
        BigDecimal qtdBD = new BigDecimal(qtd);
        item.setValorTotal(valor.multiply(qtdBD));
        
        this.produtos.add(item);
    }

    public void removerProduto(Produto produto) {

    }

    public void finalizarVenda() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public boolean isConcretizada() {
        return concretizada;
    }

    public void setConcretizada(boolean concretizada) {
        this.concretizada = concretizada;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }


    public List<VendaItem> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<VendaItem> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.vendedor);
        hash = 29 * hash + Objects.hashCode(this.cliente);
        hash = 29 * hash + Objects.hashCode(this.valorTotal);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.desconto) ^ (Double.doubleToLongBits(this.desconto) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.valorLiquido);
        hash = 29 * hash + (this.concretizada ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.situacao);
        hash = 29 * hash + Objects.hashCode(this.dataVenda);
        hash = 29 * hash + Objects.hashCode(this.produtos);
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.desconto) != Double.doubleToLongBits(other.desconto)) {
            return false;
        }
        if (this.concretizada != other.concretizada) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.valorLiquido, other.valorLiquido)) {
            return false;
        }
        if (this.situacao != other.situacao) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        /*if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }*/
        return true;
    }

}
