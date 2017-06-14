package org.dougllas.mvcp.model.jpaconverter;

import org.dougllas.mvcp.model.ObjetivoDieta;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Criado por dougllas.sousa em 06/06/2017.
 */

@Converter
public class ObjetivoDietaConverter implements AttributeConverter<ObjetivoDieta, String> {

    public String convertToDatabaseColumn(ObjetivoDieta attribute) {
        return  attribute == null ? null : attribute.getDesc();
    }

    public ObjetivoDieta convertToEntityAttribute(String dbData) {
        return dbData == null ? null : ObjetivoDieta.of(dbData);
    }
}
