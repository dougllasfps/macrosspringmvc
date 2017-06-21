package org.dougllas.mvcp.view.converter;

import org.dougllas.mvcp.tools.DecimalFormatter;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Criado por dougllas.sousa em 20/06/2017.
 */
public class DecimalPropertyEditor extends PropertyEditorSupport {

    private int fractionDigits;

    public DecimalPropertyEditor(int fractionDigits) {
        this.fractionDigits = fractionDigits;
    }

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        if(value == null || "".equals(value.trim())){
            return;
        }

        value = value.replace(".", "");
        value = value.replace(",", ".");
        BigDecimal convert = new BigDecimal(value);
        setValue(convert);
    }

    @Override
    public String getAsText() {
        if(getValue()== null){
            return "";
        }

        DecimalFormat decimalFormat = DecimalFormatter.getDecimalFormat();
        BigDecimal value = new BigDecimal((Double) getValue());
        value = value.setScale(fractionDigits, BigDecimal.ROUND_HALF_EVEN);
        decimalFormat.setMaximumFractionDigits(fractionDigits);
        decimalFormat.setMinimumFractionDigits(fractionDigits);
        String format = decimalFormat.format(value);
        return format;
    }
}