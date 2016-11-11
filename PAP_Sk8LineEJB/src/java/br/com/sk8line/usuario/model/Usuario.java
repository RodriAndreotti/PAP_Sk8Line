package br.com.sk8line.usuario.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "UsuarioSEQ", allocationSize = 1)
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(generator = "UsuarioSEQ", strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String senha;

    private String salt;

    @OneToOne
    //@JoinTable(name="role", joinColumns = {@JoinColumn(name = "role")})
    @JoinColumn(name="role")
    private Role role;

    private Boolean ativo;

    @Temporal(TemporalType.DATE)
    private Calendar dtUltimoAcesso;

    public boolean validateLogin() {
        return false;
    }

    public boolean alterarSenha() {
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(Calendar dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }

}
