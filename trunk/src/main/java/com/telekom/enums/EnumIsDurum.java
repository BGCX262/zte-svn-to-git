/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.enums;

/**
 *
 * @author esimsek
 */
public enum EnumIsDurum {

    Beklemede("Beklemede"),
    Basladı("Başladı"),
    DevamEdiyor("Devam Ediyor"),
    Tamamlandi("Tamamlandı"),
    ProblemOlustu("Problem Oluştu");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private EnumIsDurum(String value) {
        this.value = value;
    }
}
