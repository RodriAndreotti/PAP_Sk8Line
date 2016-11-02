package br.com.sk8line.garantia.model;

import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.venda.model.Venda;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "RMA_SEQ", allocationSize = 1)
public class Rma {

    @Id
    @GeneratedValue(generator = "RMA_SEQ", strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private Venda venda;

    @OneToOne
    @JoinColumn(name = "id")
    private Produto produto;

    private Enum situacao;

    private Calendar dataEntrada;

    private Calendar dataFinalizacao;

    public void abrirSolicitacao() {

    }

    public void alterarSituacao(Enum situacao) {

    }

}
