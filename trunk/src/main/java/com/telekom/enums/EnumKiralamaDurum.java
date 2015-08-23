/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.enums;

/**
 *
 * @author esimsek
 */
public enum EnumKiralamaDurum {

    Beklemede("Beklemede"),
    Görüsülüyor("Görüşülüyor"),
    Kiralandi("Kiralandı"),
    Reddedildi("Reddedildi");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private EnumKiralamaDurum(String value) {
        this.value = value;
    }
}
