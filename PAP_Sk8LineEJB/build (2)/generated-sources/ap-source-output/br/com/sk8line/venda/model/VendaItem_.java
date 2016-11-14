package br.com.sk8line.venda.model;

import br.com.sk8line.produto.model.Produto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VendaItem.class)
public abstract class VendaItem_ {

	public static volatile SingularAttribute<VendaItem, Venda> venda;
	public static volatile SingularAttribute<VendaItem, Produto> produto;
	public static volatile SingularAttribute<VendaItem, Double> desconto;
	public static volatile SingularAttribute<VendaItem, BigDecimal> valorTotal;
	public static volatile SingularAttribute<VendaItem, VendaPK> PK;
	public static volatile SingularAttribute<VendaItem, Integer> quantidade;
	public static volatile SingularAttribute<VendaItem, Double> valorUnitario;

}

