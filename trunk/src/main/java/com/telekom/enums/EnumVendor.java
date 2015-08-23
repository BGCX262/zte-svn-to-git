/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.enums;

/**
 *
 * @author esimsek
 */
public enum EnumVendor {

    ZTE("ZTE"),
    HUAWEI("HUAWEI");
    
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private EnumVendor(String value) {
        this.value = value;
    }
}
