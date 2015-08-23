/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.enums;

import java.io.Serializable;

/**
 *
 * @author esimsek
 */
public enum EnumBolge  implements Serializable{

    DOGU1("DOĞU-1"),
    BATI1("BATI-1"),
    BATI2("BATI-2"),
    KUZEY1("KUZEY-1"),
    KUZEY2("KUZEY-2"),
    GUNEY1("GÜNEY-1"),
    GUNEY2("GÜNEY-2"),
    AMERKEZ1("A.MERKEZ-1"),
    AMERKEZ2("A.MERKEZ-2");

    
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private EnumBolge(String value) {
        this.value = value;
    }
}
