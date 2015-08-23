/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.enums;

/**
 *
 * @author esimsek
 */
public enum EnumSivilIslerDurum {

    BASLAMADI("BAŞLAMADI"),
    SURUYOR("SÜRÜYOR"),
    BİTTİ("BİTTİ");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private EnumSivilIslerDurum(String value) {
        this.value = value;
    }
}
