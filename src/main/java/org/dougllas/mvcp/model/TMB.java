package org.dougllas.mvcp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Criado por dougllas.sousa em 20/06/2017.
 */

@Entity
public class TMB implements Serializable, PersistentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double peso;

    @Column
    private Integer altura;

    @Column
    private Integer idade;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TMB)) return false;

        TMB tmb = (TMB) o;

        if (getId() != null ? !getId().equals(tmb.getId()) : tmb.getId() != null) return false;
        if (getPeso() != null ? !getPeso().equals(tmb.getPeso()) : tmb.getPeso() != null) return false;
        if (getAltura() != null ? !getAltura().equals(tmb.getAltura()) : tmb.getAltura() != null) return false;
        return getIdade() != null ? getIdade().equals(tmb.getIdade()) : tmb.getIdade() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPeso() != null ? getPeso().hashCode() : 0);
        result = 31 * result + (getAltura() != null ? getAltura().hashCode() : 0);
        result = 31 * result + (getIdade() != null ? getIdade().hashCode() : 0);
        return result;
    }
}