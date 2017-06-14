package org.dougllas.mvcp.model;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */
public enum UnidadeMedida {

    GRAMA("Gramas"),
    UNID("Unidade");

    private String desc;

    UnidadeMedida(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static UnidadeMedida of(String desc){
        for (UnidadeMedida unidadeMedida : values()) {
            if(unidadeMedida.getDesc().equals(desc)){
                return unidadeMedida;
            }
        }
        return null;
    }
}
