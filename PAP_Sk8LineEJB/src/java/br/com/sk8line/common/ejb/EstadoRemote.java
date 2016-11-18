/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.common.ejb;

import br.com.sk8line.common.model.Estado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
@Remote
public interface EstadoRemote {
    public List<Estado> listar();
    public Estado getById(int id);
    public Estado getByUf(String uf);
}
