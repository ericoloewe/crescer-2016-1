package br.cwi.crescer.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Carlos H. Nonnemacher
 */
@FacesConverter("CapNascimento")
public class DateConverter implements Converter {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return value != null ? SIMPLE_DATE_FORMAT.parse(value) : null;
        } catch (ParseException ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return SIMPLE_DATE_FORMAT.format((Date) value);
    }

}
