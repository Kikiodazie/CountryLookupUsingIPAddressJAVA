package com.odazie.knowcountrybyip.geolocation;

import com.odazie.knowcountrybyip.ipaddress.IpAddress;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;

public class Geolocation {
    private IPGeolocationAPI geolocationAPI;
    private GeolocationParams geoParams;
    private IpAddress ipAddress;
    private Country country;


    public Geolocation(){
        this.geolocationAPI =  new IPGeolocationAPI("26e6b6ea29a84c52a78cb50c04d6dff5");
        this.geoParams = new GeolocationParams();
        this.ipAddress = new IpAddress();
        this.country = new Country();
    }

    public void printGeolocationDataOfIpAddress(){
        // Get geolocation for IP address () and fields (geo, time_zone and currency)
        getGeoParams().setIPAddress(ipAddress.getPublicIpAddress());
        getGeoParams().setFields("geo,time_zone,currency");
        io.ipgeolocation.api.Geolocation geolocation = getGeolocationAPI().getGeolocation(getGeoParams());
//  Check if geolocation lookup was successful
        if(geolocation.getStatus() == 200) {
            System.out.println("Ip Address Country: " + geolocation.getCountryName());
            System.out.println("Current of the country: "+ geolocation.getCurrency().getName());
            System.out.println("Date and Time in that country: " + geolocation.getTimezone().getCurrentTime());
        } else {
            System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
        }

    }

    public Country getCountry() {
        return country;
    }

    public IpAddress getIpAddress() {
        return ipAddress;
    }

    public IPGeolocationAPI getGeolocationAPI() {
        return geolocationAPI;
    }

    public GeolocationParams getGeoParams() {
        return geoParams;
    }
}
