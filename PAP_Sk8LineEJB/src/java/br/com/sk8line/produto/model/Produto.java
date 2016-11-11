package br.com.sk8line.produto.model;



import br.com.sk8line.garantia.model.TermoGarantia;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ProdutoSEQ", allocationSize = 1)
public class Produto implements Serializable {
    
    
    @Id
    @Column(name="id_produto")
    @GeneratedValue(generator = "ProdutoSEQ", strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String descricao;


    @JoinTable(name = "termo_garantia")
    @JoinColumn(name="termo_garantia", nullable = false)
    @OneToOne
    private TermoGarantia termoGarantia;

    private double largura;

    private double altura;

    private double comprimento;

    private double valor;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TermoGarantia getTermoGarantia() {
        return termoGarantia;
    }

    public void setTermoGarantia(TermoGarantia termoGarantia) {
        this.termoGarantia = termoGarantia;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    

}
