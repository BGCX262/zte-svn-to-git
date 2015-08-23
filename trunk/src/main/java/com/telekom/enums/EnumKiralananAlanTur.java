/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.enums;

/**
 *
 * @author esimsek
 */
public enum EnumKiralananAlanTur {

    OzelMulk("Özel Mülk"),
    YesilAlan("Yeşil Alan"),
    Orman("Orman"),
    Kayalik("Kayalık"),
    AskeriBolge("Askeri Bölge"),
    SitAlan("Sit Alan"),
    MilliEmlak("Milli Emlak");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private EnumKiralananAlanTur(String value) {
        this.value = value;
    }
}
