/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class DAO {
    public EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Sk8linePU");
        
        EntityManager em = factory.createEntityManager();
        factory.close();
        
        return em;
    }
}
