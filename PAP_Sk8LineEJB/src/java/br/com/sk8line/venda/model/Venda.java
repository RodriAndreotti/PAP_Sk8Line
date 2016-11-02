
package br.com.sk8line.venda.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.usuario.model.Usuario;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "VendaSEQ", allocationSize = 1)
public class Venda {

    @Id
    @GeneratedValue(generator = "VendaSEQ", strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private Usuario vendedor;

    @OneToOne
    @JoinColumn(name = "id")
    private Usuario cliente;

    private BigDecimal valorTotal;

    private double desconto;

    private BigDecimal valorLiquido;

    private boolean concretizada;

    private Enum situacao;

    private Calendar dataVenda;

    @OneToOne
    @JoinColumn(name = "id")
    private Endereco enderecoEntrega;

    
    @OneToMany(cascade=ALL, mappedBy = "venda")
    @ElementCollection(targetClass = VendaItem.class)
    private List<VendaItem> produtos;

    public boolean adicionarProduto(Produto produto) {
        return false;
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

    public Enum getSituacao() {
        return situacao;
    }

    public void setSituacao(Enum situacao) {
        this.situacao = situacao;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<VendaItem> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<VendaItem> produtos) {
        this.produtos = produtos;
    }
    
    

}
