
package br.com.sk8line.venda.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.usuario.model.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
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

    @OneToMany
    private ArrayList<VendaItem> produtos;

    public boolean adicionarProduto(Produto produto) {
        return false;
    }

    public void removerProduto(Produto produto) {

    }

    public void finalizarVenda() {

    }

}
