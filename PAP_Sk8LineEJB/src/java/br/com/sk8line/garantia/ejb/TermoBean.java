/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.garantia.ejb;

import br.com.sk8line.garantia.dao.TermoDAO;
import br.com.sk8line.garantia.model.TermoGarantia;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class TermoBean implements TermoRemote {

    @Override
    public TermoGarantia salvar(TermoGarantia termo) {
        return TermoDAO.getInstance().salvar(termo);
    }

    @Override
    public List<TermoGarantia> listar() {
        return TermoDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(TermoGarantia termo) {
        try {
            TermoDAO.getInstance().apagar(termo);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
