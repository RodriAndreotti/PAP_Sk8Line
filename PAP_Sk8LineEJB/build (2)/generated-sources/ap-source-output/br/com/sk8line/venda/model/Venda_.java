package br.com.sk8line.venda.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.usuario.model.Usuario;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Usuario> cliente;
	public static volatile SingularAttribute<Venda, Usuario> vendedor;
	public static volatile SingularAttribute<Venda, BigDecimal> valorLiquido;
	public static volatile SingularAttribute<Venda, Enum> situacao;
	public static volatile SingularAttribute<Venda, Calendar> dataVenda;
	public static volatile SingularAttribute<Venda, Double> desconto;
	public static volatile ListAttribute<Venda, VendaItem> produtos;
	public static volatile SingularAttribute<Venda, BigDecimal> valorTotal;
	public static volatile SingularAttribute<Venda, Endereco> enderecoEntrega;
	public static volatile SingularAttribute<Venda, Integer> id;
	public static volatile SingularAttribute<Venda, Boolean> concretizada;

}

