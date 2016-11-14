package br.com.sk8line.produto.model;

import br.com.sk8line.garantia.model.TermoGarantia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Estoque> estoque;
	public static volatile SingularAttribute<Produto, Double> largura;
	public static volatile SingularAttribute<Produto, Double> altura;
	public static volatile SingularAttribute<Produto, Double> valor;
	public static volatile SingularAttribute<Produto, Double> comprimento;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Integer> id;
	public static volatile SingularAttribute<Produto, TermoGarantia> termoGarantia;
	public static volatile SingularAttribute<Produto, String> descricao;

}

