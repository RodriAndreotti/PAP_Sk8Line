/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.venda.ejb;

import br.com.sk8line.garantia.model.TermoGarantia;
import br.com.sk8line.venda.model.Venda;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.lima
 */
@Remote
public interface VendaRemote {
     public Venda salvar(Venda venda);
    public List<Venda> listar();
    public boolean apagar(Venda venda);
}
