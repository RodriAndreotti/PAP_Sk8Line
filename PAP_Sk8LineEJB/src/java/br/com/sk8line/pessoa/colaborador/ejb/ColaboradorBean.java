/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.colaborador.ejb;

import br.com.sk8line.common.dao.EnderecoDAO;
import br.com.sk8line.pessoa.colaborador.dao.ColaboradorDAO;
import br.com.sk8line.pessoa.colaborador.model.Colaborador;
import br.com.sk8line.pessoa.colaborador.model.ColaboradorEndereco;
import br.com.sk8line.usuario.dao.UsuarioDAO;
import br.com.sk8line.usuario.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class ColaboradorBean implements ColaboradorRemote {

    @Override
    public Colaborador salvar(Colaborador colaborador) {
        UsuarioDAO userDao = new UsuarioDAO();
       
        colaborador.getUsuario().setAtivo(Boolean.TRUE);
        Usuario user = userDao.inserir(colaborador.getUsuario());
        colaborador.setUsuario(user);
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

    @Override
    public Colaborador getById(int id) {
        return ColaboradorDAO.getInstance().getById(id);
    }
}
