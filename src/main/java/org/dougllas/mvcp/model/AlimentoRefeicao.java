package org.dougllas.mvcp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Entity
public class AlimentoRefeicao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alimento")
    private Alimento alimento;

    @ManyToOne
    @JoinColumn(name = "id_refeicao")
    private Refeicao refeicao;

    @Column
    private BigDecimal quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlimentoRefeicao)) return false;

        AlimentoRefeicao that = (AlimentoRefeicao) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getAlimento() != null ? !getAlimento().equals(that.getAlimento()) : that.getAlimento() != null)
            return false;
        if (getRefeicao() != null ? !getRefeicao().equals(that.getRefeicao()) : that.getRefeicao() != null)
            return false;
        return getQuantidade() != null ? getQuantidade().equals(that.getQuantidade()) : that.getQuantidade() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAlimento() != null ? getAlimento().hashCode() : 0);
        result = 31 * result + (getRefeicao() != null ? getRefeicao().hashCode() : 0);
        result = 31 * result + (getQuantidade() != null ? getQuantidade().hashCode() : 0);
        return result;
    }
}
