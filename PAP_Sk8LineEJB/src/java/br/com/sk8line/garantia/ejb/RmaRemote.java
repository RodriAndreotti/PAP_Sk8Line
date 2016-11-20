/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.ejb;

import br.com.sk8line.garantia.model.Rma;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Remote
public interface RmaRemote {
    public Rma salvar(Rma rma);
    public Rma atualizarStatus(Rma rma);
    public List<Rma> listar();
    public List<Rma> listarPorPeriodo(Date inicio, Date fim);
}
