package br.com.sk8line.pessoa.model;

import br.com.sk8line.common.model.Endereco;



public interface Cadastro {

    public abstract void addEndereco(Endereco endereco);

    public abstract void delEndereco(Endereco endereco);

    public abstract void cadastrar();

    public abstract void editar();

    public abstract void apagar();

}
