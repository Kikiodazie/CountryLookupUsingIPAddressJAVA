package com.odazie.knowcountrybyip.geolocation;

public class Country {
    private String name;
    private String currency;
    private String countryCode;
    private String continent;

    public Country(){
        this.continent = null;
        this.name = null;
        this.countryCode = null;
        this.currency = null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
