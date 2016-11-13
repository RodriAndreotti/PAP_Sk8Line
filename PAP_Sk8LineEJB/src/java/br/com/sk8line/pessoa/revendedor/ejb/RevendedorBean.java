/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor.ejb;

import br.com.sk8line.pessoa.revendedor.model.Revendedor;
import br.com.sk8line.revendedor.dao.RevendedorDAO;
import java.util.List;

/**
 *
 * @author leonardo.lima
 */
public class RevendedorBean implements RevendedorRemote {

    @Override
    public Revendedor salvar(Revendedor revendedor) {
        return RevendedorDAO.getInstance().salvar(revendedor);
    }

    @Override
    public List<Revendedor> listar() {
        return RevendedorDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(Revendedor revendedor) {
        try {
            RevendedorDAO.getInstance().apagar(revendedor);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
