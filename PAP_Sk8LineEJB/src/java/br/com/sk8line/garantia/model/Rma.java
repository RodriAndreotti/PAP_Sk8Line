package br.com.sk8line.garantia.model;

import br.com.sk8line.garantia.util.Situacao;
import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.venda.model.Venda;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "Rma.findAll", query = "SELECT r FROM Rma r"),
})
public class Rma implements Serializable{

    private static final long serialVersionUID = 8655478440648665673L;
    
    
    @Id
    @Column(name = "id_rma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venda", referencedColumnName = "id_venda")
    private Venda venda;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto", referencedColumnName = "id_produto")
    private Produto produto;

    @Enumerated(EnumType.ORDINAL)
    private Situacao situacao;

    @Column(name = "data_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrada;

    @Column(name = "data_finalizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinalizacao;

    
    public Rma() {
        /*this.venda = new Venda();
        this.produto = new Produto();*/
        this.dataEntrada = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
