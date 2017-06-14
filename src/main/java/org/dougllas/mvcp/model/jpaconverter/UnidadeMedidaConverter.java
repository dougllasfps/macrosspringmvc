package org.dougllas.mvcp.model.jpaconverter;

import org.dougllas.mvcp.model.UnidadeMedida;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Converter
public class UnidadeMedidaConverter implements AttributeConverter<UnidadeMedida, String> {

    public String convertToDatabaseColumn(UnidadeMedida attribute) {
        return attribute == null ? null : attribute.getDesc();
    }

    public UnidadeMedida convertToEntityAttribute(String dbData) {
        return dbData == null ? null : UnidadeMedida.of(dbData);
    }
}
