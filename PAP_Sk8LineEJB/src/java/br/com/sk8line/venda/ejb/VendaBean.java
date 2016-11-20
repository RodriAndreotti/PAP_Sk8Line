/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.venda.ejb;

import br.com.sk8line.produto.dao.EstoqueDAO;
import br.com.sk8line.produto.model.Estoque;
import br.com.sk8line.venda.dao.VendaDAO;
import br.com.sk8line.venda.model.Venda;
import br.com.sk8line.venda.model.VendaItem;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.Stateless;

/**
 *
 * @author leonardo.lima
 */
@Stateless
public class VendaBean implements VendaRemote {

    @Override
    public Venda salvar(Venda venda) {
        Venda v = VendaDAO.getInstance().salvar(venda);
        if(v != null){
            ListIterator it = v.getProdutos().listIterator();
            while(it.hasNext()){
                VendaItem item = (VendaItem) it.next();
                Estoque estoque = item.getProduto().getEstoque();
                estoque.setQuantidade(estoque.getQuantidade() - item.getQuantidade());
                EstoqueDAO.getInstance().atualizar(estoque);
            }
        }
        
        return venda;
    }

    @Override
    public List<Venda> listar() {
        return VendaDAO.getInstance().listar();
    }

    @Override
    public boolean apagar(Venda venda) {
        try {
            VendaDAO.getInstance().apagar(venda);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Venda getById(int id) {
        return VendaDAO.getInstance().getById(id);
    }
}
