/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sk8line.common.dao;

import br.com.sk8line.common.model.Endereco;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * @author Rodrigo Teixeira Andreotti <ro.andriotti@gmail.com>
 */
public class EnderecoDAO extends DAO{
    private static EnderecoDAO instance;
    
    private EnderecoDAO(){}
    
    public static EnderecoDAO getInstance(){
        if(instance == null){
            instance = new EnderecoDAO();
        }
        
        return instance;
    }
    
    public Endereco findByCep(String cep){
        
        Endereco endereco;
        CriteriaBuilder builder = this.getCriteriaBuilder();
        CriteriaQuery<Endereco> estadoQuery = builder.createQuery(Endereco.class);
        Root<Endereco> end = estadoQuery.from(Endereco.class);

        try {

            TypedQuery<Endereco> typedQuery = this.getEntityManager().createQuery(
                    estadoQuery
                            .where(
                                    builder.like(end.<String>get("cep"), cep.replaceAll("_", ""))
                            )
            );

            endereco = typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            endereco = null;
        }

        return endereco;
    }
    
    public Endereco inserir(Endereco endereco){
        this.getEntityManager().persist(endereco);
        this.getEntityManager().flush();
        return endereco;
    }
    
    /**
     * Retorna uma referência Não Detached do endereço
     * @param endereco
     * @return 
     */
    public Endereco loadReference(Endereco endereco) {
        return this.getEntityManager().contains(endereco) ? endereco : this.getEntityManager().getReference(Endereco.class,endereco.getId());
    }
}
