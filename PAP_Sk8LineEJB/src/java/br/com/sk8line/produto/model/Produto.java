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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ProdutoSEQ", allocationSize = 1)
public class Produto implements CadastroProduto, Serializable {
    
    
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

    public void cadastrar() {

    }

    public void editar() {

    }

    public void apagar() {

    }

    public void alterarPreco() {

    }

}
