package com.example.cryptoworld.models.enums;

public enum EnumCountry {
    Albania("Albania"),
    Latvia("Latvia"),
    Andorra("Andorra"),
    Liechtenstein ("Liechtenstein"),
    Armenia("Armenia"),
    Lithuania("Lithuania"),
    Austria("Austria"),
    Luxembourg("Luxembourg"),
    Azerbaijan("Azerbaijan"),
    Malta("Malta"),
    Belarus("Belarus"),
    Moldova("Moldova"),
    Belgium("Belgium"),
    Monaco("Monaco"),
    Bosnia_Herzegovina("Bosnia Herzegovina"),
    Montenegro("Montenegro"),
    Bulgaria("Bulgaria"),
    Netherlands("Netherlands"),
    Croatia("Croatia"),
    Norway("Norway"),
    Cyprus("Cyprus"),
    Poland("Poland"),
    Czech("Czech"),
    Portugal("Portugal"),
    Denmark("Denmark"),
    Romania("Romania"),
    Estonia("Estonia"),
    Russia("Russia"),
    Finland("Finland"),
    San_Marino("San Marino"),
    Macedonia("Macedonia"),
    Serbia("Serbia"),
    France("France"),
    Slovakia("Slovakia"),
    Georgia("Georgia"),
    Slovenia("Slovenia"),
    Germany("Germany"),
    Spain("Spain"),
    Greece("Greece"),
    Sweden("Sweden"),
    Hungary("Hungary"),
    Iceland("Iceland"),
    Switzerland("Switzerland"),
    Ireland("Ireland"),
    Turkey("Turkey"),
    Italy("Italy"),
    Ukraine("Ukraine"),
    Kosovo("Kosovo"),
    United_Kingdom("United Kingdom");

    private String value;


    EnumCountry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
