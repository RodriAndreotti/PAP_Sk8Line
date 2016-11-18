/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.common.ejb;

import br.com.sk8line.common.dao.EstadoDAO;
import br.com.sk8line.common.model.Estado;
import java.util.List;
import javax.ejb.Stateless;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Stateless
public class EstadoBean implements EstadoRemote {

    @Override
    public List<Estado> listar() {
        return EstadoDAO.getInstance().listar();
    }

    @Override
    public Estado getById(int id) {
        return EstadoDAO.getInstance().getById(id);
    }

    @Override
    public Estado getByUf(String uf) {
        return EstadoDAO.getInstance().getByUf(uf);
    }

}
