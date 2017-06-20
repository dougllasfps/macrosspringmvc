package org.dougllas.mvcp.model;

import org.dougllas.mvcp.model.jpaconverter.UnidadeMedidaConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Entity
public class Alimento implements Serializable, PersistentEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Convert(converter = UnidadeMedidaConverter.class)
    @Column(name = "unidade_medida")
    private UnidadeMedida unidadeMedida;

    @Column(precision = 10, scale = 3)
    private BigDecimal quantidade;

    @Transient
    private Double calorias;

    @Column
    private Double carbos;

    @Column
    private Double proteina;

    @Column
    private Double gordura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Double getCarbos() {
        return carbos;
    }

    public void setCarbos(Double carbos) {
        this.carbos = carbos;
    }

    public Double getProteina() {
        return proteina;
    }

    public void setProteina(Double proteina) {
        this.proteina = proteina;
    }

    public Double getGordura() {
        return gordura;
    }

    public void setGordura(Double gordura) {
        this.gordura = gordura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alimento)) return false;

        Alimento alimento = (Alimento) o;

        if (getId() != null ? !getId().equals(alimento.getId()) : alimento.getId() != null) return false;
        if (getDescricao() != null ? !getDescricao().equals(alimento.getDescricao()) : alimento.getDescricao() != null)
            return false;
        if (getUnidadeMedida() != alimento.getUnidadeMedida()) return false;
        if (getQuantidade() != null ? !getQuantidade().equals(alimento.getQuantidade()) : alimento.getQuantidade() != null)
            return false;
        if (getCalorias() != null ? !getCalorias().equals(alimento.getCalorias()) : alimento.getCalorias() != null)
            return false;
        if (getCarbos() != null ? !getCarbos().equals(alimento.getCarbos()) : alimento.getCarbos() != null)
            return false;
        if (getProteina() != null ? !getProteina().equals(alimento.getProteina()) : alimento.getProteina() != null)
            return false;
        return getGordura() != null ? getGordura().equals(alimento.getGordura()) : alimento.getGordura() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getUnidadeMedida() != null ? getUnidadeMedida().hashCode() : 0);
        result = 31 * result + (getQuantidade() != null ? getQuantidade().hashCode() : 0);
        result = 31 * result + (getCalorias() != null ? getCalorias().hashCode() : 0);
        result = 31 * result + (getCarbos() != null ? getCarbos().hashCode() : 0);
        result = 31 * result + (getProteina() != null ? getProteina().hashCode() : 0);
        result = 31 * result + (getGordura() != null ? getGordura().hashCode() : 0);
        return result;
    }
}
