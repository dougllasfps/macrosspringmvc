package org.dougllas.mvcp.model;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */
public enum ObjetivoDieta {

    BULKING("bulking"),
    CUTTING("cutting"),
    OFF("off");

    private String desc;

    ObjetivoDieta(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static ObjetivoDieta of(String desc){
        for (ObjetivoDieta value : values()) {
            if(value.getDesc().equals(desc)){
                return value;
            }
        }
        return null;
    }
}
