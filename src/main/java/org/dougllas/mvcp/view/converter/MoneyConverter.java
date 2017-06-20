package org.dougllas.mvcp.view.converter;

import org.dougllas.mvcp.tools.DecimalFormatter;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Criado por dougllas.sousa em 20/06/2017.
 */
public class MoneyConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        if (value != null && !value.isEmpty()) {
            value = value.replace(".", "");
            value = value.replace(",", ".");
            BigDecimal convert = new BigDecimal(value);
            setValue(convert);
        }
    }

    @Override
    public String getAsText() {
        if(getValue()== null){
            return "";
        }

        DecimalFormat decimalFormat = DecimalFormatter.getDecimalFormat();
        BigDecimal value = new BigDecimal((Double) getValue());
        value = value.setScale(3, BigDecimal.ROUND_HALF_EVEN);
        decimalFormat.setMaximumFractionDigits(3);
        decimalFormat.setMinimumFractionDigits(3);
        String format = decimalFormat.format(value);
        return format;
    }
}