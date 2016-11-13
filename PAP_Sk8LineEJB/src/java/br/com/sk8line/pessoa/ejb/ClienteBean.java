/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.ejb;

import br.com.sk8line.pessoa.dao.PessoaDAO;
import br.com.sk8line.pessoa.model.Pessoa;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class ClienteBean implements ClienteRemote {

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return PessoaDAO.getInstance().salvar(pessoa);
    }

    @Override
    public List<Pessoa> listar() {
        return PessoaDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(Pessoa pessoa) {
        try {
            PessoaDAO.getInstance().apagar(pessoa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}