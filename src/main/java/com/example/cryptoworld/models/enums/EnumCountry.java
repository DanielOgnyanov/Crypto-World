package com.example.cryptoworld.models.enums;

public enum EnumCountry {
    Albania,
    Latvia,
    Andorra,
    Liechtenstein ,
    Armenia,
    Lithuania,
    Austria,
    Luxembourg,
    Azerbaijan,
    Malta,
    Belarus,
    Moldova,
    Belgium,
    Monaco,
    Bosnia_Herzegovina,
    Montenegro,
    Bulgaria,
    Netherlands,
    Croatia,
    Norway,
    Cyprus,
    Poland,
    Czech,
    Republic,
    Portugal,
    Denmark,
    Romania,
    Estonia,
    Russia,
    Finland,
    San_Marino,
    Macedonia,
    Serbia,
    France,
    Slovakia,
    Georgia,
    Slovenia,
    Germany,
    Spain,
    Greece,
    Sweden,
    Hungary,
    Iceland,
    Switzerland,
    Ireland,
    Turkey,
    Italy,
    Ukraine,
    Kosovo,
    United_Kingdom;

    private String value;


    EnumCountry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
