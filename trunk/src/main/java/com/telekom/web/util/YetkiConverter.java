
package com.telekom.web.util;

import com.telekom.auth.entity.Yetki;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author esimsek
 */
@FacesConverter("YetkiConverter")
public class YetkiConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String str) {
        //  System.out.println(str);
        String values[] = str.split(":");
        Yetki Yetki = new Yetki();
        if (values.length == 3) {
            Yetki.setId(Long.parseLong(values[0]));
            Yetki.setAdi(values[1]);
            Yetki.setAciklama(values[2]);
            return Yetki;
        }
        return Yetki;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object object) {
        Yetki Yetki = (Yetki) object;
        String str = "";
        if (Yetki != null) {
            str = String.valueOf(Yetki.getId()) + ":" + Yetki.getAdi() + ":"
                    + Yetki.getAciklama();
        }
        return str;
    }
}
