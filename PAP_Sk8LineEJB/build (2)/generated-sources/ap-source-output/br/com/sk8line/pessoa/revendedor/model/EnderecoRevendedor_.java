package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.common.model.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EnderecoRevendedor.class)
public abstract class EnderecoRevendedor_ {

	public static volatile SingularAttribute<EnderecoRevendedor, Integer> tipo;
	public static volatile SingularAttribute<EnderecoRevendedor, Revendedor> revendedor;
	public static volatile SingularAttribute<EnderecoRevendedor, String> complemento;
	public static volatile SingularAttribute<EnderecoRevendedor, Endereco> endereco;
	public static volatile SingularAttribute<EnderecoRevendedor, Integer> numero;
	public static volatile SingularAttribute<EnderecoRevendedor, RevEndPK> pk;

}

