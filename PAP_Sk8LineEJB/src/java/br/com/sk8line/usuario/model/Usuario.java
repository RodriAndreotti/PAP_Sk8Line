package br.com.sk8line.usuario.model;

import java.util.Calendar;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="UsuarioSEQ", allocationSize = 1)
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(generator = "UsuarioSEQ", strategy = GenerationType.IDENTITY)
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
