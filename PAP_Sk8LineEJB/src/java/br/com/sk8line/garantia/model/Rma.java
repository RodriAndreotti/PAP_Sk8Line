
package br.com.sk8line.garantia.model;

import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.venda.model.Venda;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rma {

    @Id
    private int id;

    @EJB
    private Venda venda;

    private Produto produto;

    private Enum situacao;

    private Calendar dataEntrada;

    private Calendar dataFinalizacao;

    public void abrirSolicitacao() {

    }

    public void alterarSituacao(Enum situacao) {

    }

}
