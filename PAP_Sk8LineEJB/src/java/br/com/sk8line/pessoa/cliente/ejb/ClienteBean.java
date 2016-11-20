/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.cliente.ejb;

import br.com.sk8line.pessoa.cliente.model.ClientePessoaFisica;
import br.com.sk8line.pessoa.cliente.dao.ClienteDAO;
import br.com.sk8line.pessoa.model.Pessoa;
import br.com.sk8line.usuario.dao.UsuarioDAO;
import br.com.sk8line.usuario.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class ClienteBean implements ClienteRemote {

    @Override
    public ClientePessoaFisica salvar(ClientePessoaFisica pessoa) {
        UsuarioDAO userDao = new UsuarioDAO();
       
        pessoa.getUsuario().setAtivo(Boolean.TRUE);
        Usuario user = userDao.inserir(pessoa.getUsuario());
        pessoa.setUsuario(user);
        return ClienteDAO.getInstance().salvar(pessoa);
    }

    @Override
    public List<ClientePessoaFisica> listar() {
        return ClienteDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(ClientePessoaFisica pessoa) {
        try {
            ClienteDAO.getInstance().apagar(pessoa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}