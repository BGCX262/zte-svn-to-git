package com.telekom.web.util;

import com.telekom.service.TelekomService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author esimsek
 */
public class WebUtil {

    public WebUtil() {
    }

    public static Map getSessionMap(FacesContext ctx) {
        return ctx.getExternalContext().getSessionMap();
    }

    public Boolean isPostBack(FacesContext ctx) {
        if (ctx.getRenderResponse()) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public void showFacesMessage(FacesContext currentInstance, String mesaj, Severity severity) {
        FacesMessage fMessage = new FacesMessage(severity, "Not", mesaj);
        currentInstance.addMessage(mesaj, fMessage);
    }

    public List<SelectItem> selectOneMenuDoldur(List<? extends Object> o, String displayValue, String displayName,String sehirKod) throws Exception {
        List<SelectItem> items = new ArrayList<SelectItem>();
        //items.add(new SelectItem("-1", "Seciniz"));
        for (Iterator<Object> it = (Iterator<Object>) o.iterator(); it.hasNext();) {
            Object object = it.next();
            items.add(new SelectItem(BeanUtils.getProperty(object, displayValue), BeanUtils.getProperty(object, displayName),sehirKod));
        }
        return items;
    }
}
