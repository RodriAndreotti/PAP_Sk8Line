/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.ejb;

import br.com.sk8line.garantia.model.TermoGarantia;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo
 */
@Remote
public interface TermoRemote {
    public TermoGarantia salvar(TermoGarantia termo);
    public List<TermoGarantia> listar();
    public boolean apagar(TermoGarantia termo);
    public TermoGarantia getById(int id);
}
