package com.example.cryptoworld.models.enums;

public enum EnumCountry {
    Albania("Albania"),
    Azerbaijan("Azerbaijan"),
    Andorra("Andorra"),
    Armenia("Armenia"),
    Austria("Austria"),
    Belarus("Belarus"),
    Belgium("Belgium"),
    Bosnia_Herzegovina("Bosnia Herzegovina"),
    Bulgaria("Bulgaria"),
    Croatia("Croatia"),
    Czech("Czech"),
    Cyprus("Cyprus"),
    Denmark("Denmark"),
    Estonia("Estonia"),
    France("France"),
    Finland("Finland"),
    Georgia("Georgia"),
    Greece("Greece"),
    Germany("Germany"),
    Hungary("Hungary"),
    Iceland("Iceland"),
    Ireland("Ireland"),
    Italy("Italy"),
    Kosovo("Kosovo"),
    Latvia("Latvia"),
    Liechtenstein ("Liechtenstein"),
    Lithuania("Lithuania"),
    Luxembourg("Luxembourg"),
    Moldova("Moldova"),
    Malta("Malta"),
    Monaco("Monaco"),
    Montenegro("Montenegro"),
    Macedonia("Macedonia"),
    Netherlands("Netherlands"),
    Norway("Norway"),
    Poland("Poland"),
    Portugal("Portugal"),
    Romania("Romania"),
    Russia("Russia"),
    San_Marino("San Marino"),
    Slovakia("Slovakia"),
    Serbia("Serbia"),
    Slovenia("Slovenia"),
    Spain("Spain"),
    Sweden("Sweden"),
    Switzerland("Switzerland"),
    Turkey("Turkey"),
    Ukraine("Ukraine"),
    United_Kingdom("United Kingdom");



    private String value;


    EnumCountry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
