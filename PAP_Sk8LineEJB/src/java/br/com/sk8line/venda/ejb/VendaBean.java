/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.venda.ejb;

import br.com.sk8line.venda.dao.VendaDAO;
import br.com.sk8line.venda.model.Venda;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class VendaBean implements VendaRemote {

    @Override
    public Venda salvar(Venda venda) {
        return VendaDAO.getInstance().salvar(venda);
    }

    @Override
    public List<Venda> listar() {
        return VendaDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(Venda venda) {
        try {
            VendaDAO.getInstance().apagar(venda);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Venda getById(int id) {
        return VendaDAO.getInstance().getById(id);
    }
}
