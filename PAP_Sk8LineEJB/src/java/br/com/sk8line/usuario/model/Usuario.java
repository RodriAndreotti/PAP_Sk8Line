package br.com.sk8line.usuario.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    private int id;

    private String email;

    private String senha;

    private String salt;

    private Role role;

    private Boolean ativo;

    private Calendar dtUltimoAcesso;

    public boolean validateLogin() {
        return false;
    }

    public boolean alterarSenha() {
        return false;
    }

}
