/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.ejb;

import br.com.sk8line.pessoa.model.Pessoa;
import java.util.List;

/**
 *
 * @author leonardo.lima
 */
public interface ClienteRemote {

    public Pessoa salvar(Pessoa pessoa);

    public List<Pessoa> listar();

    public boolean apagar(Pessoa pessoa);
}
