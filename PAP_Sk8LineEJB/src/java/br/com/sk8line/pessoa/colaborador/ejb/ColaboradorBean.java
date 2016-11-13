/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.colaborador.ejb;

import br.com.sk8line.pessoa.colaborador.dao.ColaboradorDAO;
import br.com.sk8line.pessoa.model.Colaborador;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class ColaboradorBean implements ColaboradorRemote {

    @Override
    public Colaborador salvar(Colaborador colaborador) {
        return ColaboradorDAO.getInstance().salvar(colaborador);
    }

    @Override
    public List<Colaborador> listar() {
        return ColaboradorDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(Colaborador colaborador) {
        try {
            ColaboradorDAO.getInstance().apagar(colaborador);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
