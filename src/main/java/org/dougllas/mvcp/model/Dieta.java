package org.dougllas.mvcp.model;

import org.dougllas.mvcp.model.jpaconverter.ObjetivoDietaConverter;

import javax.persistence.*;
import java.util.List;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Entity
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Convert(converter = ObjetivoDietaConverter.class)
    private ObjetivoDieta objetivo;

    @OneToMany(mappedBy = "dieta")
    private List<Refeicao> refeicoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjetivoDieta getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ObjetivoDieta objetivo) {
        this.objetivo = objetivo;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
}
