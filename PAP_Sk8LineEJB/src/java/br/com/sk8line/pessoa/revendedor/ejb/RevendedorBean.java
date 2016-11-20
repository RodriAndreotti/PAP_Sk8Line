/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor.ejb;

import br.com.sk8line.pessoa.revendedor.dao.RevendedorDAO;
import br.com.sk8line.pessoa.revendedor.model.Revendedor;
import br.com.sk8line.usuario.dao.UsuarioDAO;
import br.com.sk8line.usuario.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class RevendedorBean implements RevendedorRemote {

    /**
     * Salva o Revendedor
     * @param revendedor
     * @return
     */
    @Override
    public Revendedor salvar(Revendedor revendedor) {
        UsuarioDAO userDao = new UsuarioDAO();
       
        revendedor.getUsuario().setAtivo(Boolean.TRUE);
        Usuario user = userDao.inserir(revendedor.getUsuario());
        revendedor.setUsuario(user);
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

    @Override
    public Revendedor getById(int id) {
        return RevendedorDAO.getInstance().getById(id);
    }
}
