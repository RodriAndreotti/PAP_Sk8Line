/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.pessoa.colaborador.ejb;

import br.com.sk8line.pessoa.model.Colaborador;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.lima
 */
@Remote
public interface ColaboradorRemote {

    public Colaborador salvar(Colaborador colaborador);

    public List<Colaborador> listar();

    public boolean apagar(Colaborador colaborador);
}
