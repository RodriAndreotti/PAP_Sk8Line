/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.garantia.dao;

import br.com.sk8line.common.dao.DAO;
import br.com.sk8line.garantia.model.Rma;
import java.util.List;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class RmaDAO extends DAO{
    
    private static RmaDAO instance;
    
    
    public static RmaDAO getInstance() {
        if(instance == null){
            instance = new RmaDAO();
        }
        
        return instance;
    }
    
    private RmaDAO(){}

    public List<Rma> listar(){
        return this.getEntityManager().createNamedQuery("Rma.findAll", Rma.class).getResultList();
    }
}
