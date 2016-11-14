package br.com.sk8line.produto.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estoque.class)
public abstract class Estoque_ {

	public static volatile SingularAttribute<Estoque, Date> ultimaAtualizacao;
	public static volatile SingularAttribute<Estoque, Produto> produto;
	public static volatile SingularAttribute<Estoque, Integer> id;
	public static volatile SingularAttribute<Estoque, Integer> quantidade;

}

