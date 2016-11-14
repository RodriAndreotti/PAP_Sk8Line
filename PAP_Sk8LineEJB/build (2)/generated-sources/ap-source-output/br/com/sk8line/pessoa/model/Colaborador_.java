package br.com.sk8line.pessoa.model;

import br.com.sk8line.common.model.Endereco;
import br.com.sk8line.usuario.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Colaborador.class)
public abstract class Colaborador_ extends br.com.sk8line.pessoa.model.Pessoa_ {

	public static volatile SingularAttribute<Colaborador, Endereco> enderecos;
	public static volatile SingularAttribute<Colaborador, Usuario> usuario;
	public static volatile SingularAttribute<Colaborador, Integer> id;

}

