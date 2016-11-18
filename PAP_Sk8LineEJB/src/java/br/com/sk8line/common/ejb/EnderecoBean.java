/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.common.ejb;

import br.com.sk8line.common.dao.EnderecoDAO;
import br.com.sk8line.common.model.Endereco;
import javax.ejb.Stateless;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Stateless
public class EnderecoBean implements EnderecoRemote{

    @Override
    public Endereco getByCep(String cep) {
        return EnderecoDAO.getInstance().findByCep(cep);
    }

    @Override
    public Endereco inserir(Endereco endereco) {
        return EnderecoDAO.getInstance().inserir(endereco);
    }

}
