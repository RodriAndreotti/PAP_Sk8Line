/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.garantia.ejb;

import br.com.sk8line.garantia.dao.RmaDAO;
import br.com.sk8line.garantia.model.Rma;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Integra o Managed Bean com o DAO
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Stateless
public class RmaBean implements RmaRemote{

    @Override
    public Rma salvar(Rma rma) {
        return RmaDAO.getInstance().salvar(rma);
    }

    @Override
    public Rma atualizarStatus(Rma rma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rma> listar() {
        return RmaDAO.getInstance().listar();
    }

    @Override
    public List<Rma> listarPorPeriodo(Date inicio, Date fim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
