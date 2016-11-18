package br.com.sk8line.usuario.model;

import br.com.sk8line.usuario.dao.UsuarioDAO;
import br.com.sk8line.usuario.service.Password;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    
    private String senha;

    private String salt;

    @OneToOne
    @JoinColumn(name="role")
    private Role role;

    private Boolean ativo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUltimoAcesso;

    public boolean validateLogin() {
        return false;
    }

    public boolean alterarSenha() {
        return false;
    }

    public int getId() {
        return (id == 0 ? null : id);
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

    public Date getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(Date dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }
    
    @PrePersist
    private void criptografa(){
        UsuarioDAO dao = new UsuarioDAO();
        String dbSalt = dao.obterSalt(this.getEmail());
        Password passwd = new Password(dbSalt);
        this.setSalt(passwd.getSalt());
        this.setSenha(passwd.encrypt(this.getSenha()));
    }

}
