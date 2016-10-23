
package br.com.sk8line.venda.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.usuario.model.Usuario;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import static javax.persistence.CascadeType.ALL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Venda {

    @Id
    private int id;

    private Usuario vendedor;

    private Usuario cliente;

    private BigDecimal valorTotal;

    private double desconto;

    private BigDecimal valorLiquido;

    private boolean concretizada;

    private Enum situacao;

    private Calendar dataVenda;

    private Endereco enderecoEntrega;

    
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

    @OneToMany(cascade=ALL, mappedBy="vendaitem")
    @JoinTable(name = "venda_produto", joinColumns = {@JoinColumn(name="venda")})
    public List<VendaItem> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<VendaItem> produtos) {
        this.produtos = produtos;
    }
    
    

}
