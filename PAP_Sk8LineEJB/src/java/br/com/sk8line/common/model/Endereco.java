
package br.com.sk8line.common.model;

import javax.persistence.Entity;

@Entity
public class Endereco {

    private int id;

    private String logradouro;

    private int numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private Estado estado;

    private String cep;

    private int tipo;

    public void salvarEndereco() {

    }

}
