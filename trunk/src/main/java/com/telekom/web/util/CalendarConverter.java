/*
*Bu dosyanın tüm yasal hakları POLSAN'a aittir.
*İzinsiz kullanılması ve çoğaltılması yasaktır.
*/

package com.telekom.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *TODO:Ahmet Emre Başakcioğlu-Sinif Aciklamasi yazilacak.
 *
 *Yazar Bilgileri: Ahmet Emre Başakcioğlu
 *
 *Tarih : Dec 17, 2010
 */

@FacesConverter("calendarConverter")
public class CalendarConverter implements Converter{

    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Calendar cal= null;
        if(string!=null&&!string.equals(""))
        {
            cal= Calendar.getInstance();
            DateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
            Date d;
            try {
                d = sdf.parse(string);
             //   System.out.println(d.toString());
                cal.setTime(d);
            } catch (ParseException ex) {
                Logger.getLogger(CalendarConverter.class.getName()).log(Level.SEVERE, null, ex);
             //   System.out.println("bASASARISIZZZZ");
            }
            
        }
        return cal;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String strdate = null;
       // System.out.println(o);
        if(o!=null&&!o.equals(""))
        {
             Calendar cal=(Calendar)o;
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            strdate = sdf.format(cal.getTime());
        }
        return strdate;

    }


}