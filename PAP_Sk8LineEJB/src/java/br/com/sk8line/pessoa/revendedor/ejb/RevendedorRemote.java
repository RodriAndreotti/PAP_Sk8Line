/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.revendedor.ejb;

import br.com.sk8line.pessoa.revendedor.model.Revendedor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.lima
 */
@Remote
public interface RevendedorRemote {

    public Revendedor salvar(Revendedor revendedor);

    public List<Revendedor> listar();

    public boolean apagar(Revendedor revendedor);

    public Revendedor getById(int id);
}
