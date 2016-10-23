/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sk8line.common.dao;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.ProviderUtil;

/**
 *
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public abstract class DAO {

    private EntityManager em;

    protected EntityManager getEntityManager() {
        
        if (this.em == null) {
            
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("PAPSk8LineEJBPU");

            EntityManager em = factory.createEntityManager();
            // factory.close();
            this.em = em;
        }
        
        
        

        return this.em;
    }
}
