package br.com.sk8line.produto.model;



import br.com.sk8line.garantia.model.TermoGarantia;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = -3710183666062195577L;
    
    
    @Id
    @Column(name="id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String descricao;


    
    @OneToOne
    @JoinColumn(name = "termo_garantia")
    private TermoGarantia termoGarantia;

    private double largura;

    private double altura;

    private double comprimento;

    private double valor;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private Estoque estoque;

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

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        estoque.setProduto(this);
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.descricao);
        hash = 83 * hash + Objects.hashCode(this.termoGarantia);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.largura) ^ (Double.doubleToLongBits(this.largura) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.comprimento) ^ (Double.doubleToLongBits(this.comprimento) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.estoque);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.largura) != Double.doubleToLongBits(other.largura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.comprimento) != Double.doubleToLongBits(other.comprimento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.termoGarantia, other.termoGarantia)) {
            return false;
        }
        if (!Objects.equals(this.estoque, other.estoque)) {
            return false;
        }
        return true;
    }

    
}
