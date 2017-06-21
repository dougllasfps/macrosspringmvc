package org.dougllas.mvcp.view.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Criado por dougllas.sousa em 20/06/2017.
 */
public class CalendarPropertyEditor extends PropertyEditorSupport {

    private static final SimpleDateFormat DATE_FORMAT;

    static {
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text == null || "".equals(text.trim())){
            return;
        }
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DATE_FORMAT.parse(text));
            setValue(cal);
        } catch (ParseException e) {
            setValue(null);
        }
    }

    @Override
    public String getAsText() {
        if (getValue() == null) {
            return "";
        }
        return DATE_FORMAT.format(((Calendar) getValue()).getTime());
    }
}
