package br.com.sk8line.pessoa.revendedor.model;

import br.com.sk8line.usuario.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Revendedor.class)
public abstract class Revendedor_ extends br.com.sk8line.pessoa.model.Pessoa_ {

	public static volatile SingularAttribute<Revendedor, String> telefone;
	public static volatile SingularAttribute<Revendedor, EnderecoRevendedor> enderecos;
	public static volatile SingularAttribute<Revendedor, Usuario> usuario;
	public static volatile SingularAttribute<Revendedor, String> cnpj;
	public static volatile SingularAttribute<Revendedor, Integer> id;
	public static volatile SingularAttribute<Revendedor, String> razaoSocial;

}

