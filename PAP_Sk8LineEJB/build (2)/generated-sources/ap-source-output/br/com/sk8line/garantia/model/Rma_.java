package br.com.sk8line.garantia.model;

import br.com.sk8line.produto.model.Produto;
import br.com.sk8line.venda.model.Venda;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rma.class)
public abstract class Rma_ {

	public static volatile SingularAttribute<Rma, Venda> venda;
	public static volatile SingularAttribute<Rma, Enum> situacao;
	public static volatile SingularAttribute<Rma, Produto> produto;
	public static volatile SingularAttribute<Rma, Calendar> dataEntrada;
	public static volatile SingularAttribute<Rma, Integer> id;
	public static volatile SingularAttribute<Rma, Calendar> dataFinalizacao;

}

