/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.produto.ejb;

import br.com.sk8line.produto.model.Produto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rodrigo
 */
@Remote
public interface ProdutoRemote {
    public Produto salvar(Produto produto);
    public List<Produto> listar();
    public boolean apagar(Produto produto);
}
