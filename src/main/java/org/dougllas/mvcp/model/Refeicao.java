package org.dougllas.mvcp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Entity
public class Refeicao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_dieta")
    private Dieta dieta;

    @OneToMany(mappedBy = "refeicao")
    private List<AlimentoRefeicao> alimentos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public List<AlimentoRefeicao> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<AlimentoRefeicao> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Refeicao)) return false;

        Refeicao refeicao = (Refeicao) o;

        if (getId() != null ? !getId().equals(refeicao.getId()) : refeicao.getId() != null) return false;
        if (getNumero() != null ? !getNumero().equals(refeicao.getNumero()) : refeicao.getNumero() != null)
            return false;
        if (getDieta() != null ? !getDieta().equals(refeicao.getDieta()) : refeicao.getDieta() != null) return false;
        return getAlimentos() != null ? getAlimentos().equals(refeicao.getAlimentos()) : refeicao.getAlimentos() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumero() != null ? getNumero().hashCode() : 0);
        result = 31 * result + (getDieta() != null ? getDieta().hashCode() : 0);
        result = 31 * result + (getAlimentos() != null ? getAlimentos().hashCode() : 0);
        return result;
    }
}
