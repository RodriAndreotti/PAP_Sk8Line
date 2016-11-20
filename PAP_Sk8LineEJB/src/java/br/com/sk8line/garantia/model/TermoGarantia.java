package br.com.sk8line.garantia.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "termo_garantia")
public class TermoGarantia implements Serializable{

    private static final long serialVersionUID = -3652872628478117580L;

    @Id
    @Column(name = "id_termo_garantia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private int periodo;

    private String termos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getTermos() {
        return termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + this.periodo;
        hash = 79 * hash + Objects.hashCode(this.termos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TermoGarantia other = (TermoGarantia) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.termos, other.termos)) {
            return false;
        }
        return true;
    }

    

    

    
}
