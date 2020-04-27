package com.odazie.knowcountrybyip.geolocation;

import com.odazie.knowcountrybyip.ipaddress.IpAddress;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;

import java.util.Scanner;

public class Geolocation {
    private IPGeolocationAPI geolocationAPI;
    private GeolocationParams geoParams;
    private IpAddress ipAddress;
    private Country country;
    private io.ipgeolocation.api.Geolocation geolocation;
    private String ipAddressInUse;


    public Geolocation(){
        this.geolocationAPI =  new IPGeolocationAPI("26e6b6ea29a84c52a78cb50c04d6dff5");
        this.geoParams = new GeolocationParams();
        this.geolocation = getGeolocationAPI().getGeolocation(getGeoParams());
        this.ipAddress = new IpAddress();
        this.country = new Country();
    }


    public void knowCountryByIp(){
        // Get geolocation for IP address () and fields (geo, time_zone and currency)
        getGeoParams().setFields("geo,time_zone,currency");
        System.out.println("LookUp Country data of your IP Address or Any IP Address!!!");
        System.out.println("Enter 1 to lookup your current IP address country data or 2 to search any other ip");
        System.out.print("Enter: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            setIpAddressInUse(ipAddress.getPublicIpAddress());
            getGeoParams().setIPAddress(getIpAddressInUse());
            printGeolocationDataOfAnIpAddress();
        }else if(input == 2){
            System.out.print("Enter Ip Address (eg 12.3.2.3): ");
            Scanner scanner2 = new Scanner(System.in);
            String ipAddress = scanner2.nextLine();
            setIpAddressInUse(ipAddress);
            getGeoParams().setIPAddress(getIpAddressInUse());
            printGeolocationDataOfAnIpAddress();
        }else {
            System.out.println("Wrong input!!!!");
            System.out.println("You inputted an invalid response.");
        }


    }

    public void printGeolocationDataOfAnIpAddress(){

//  Check if geolocation lookup was successful
        if(getGeolocation().getStatus() == 200) {
            System.out.println("Ip Address Country: " + getGeolocation().getCountryName());
            System.out.println("Currency of the country: "+ getGeolocation().getCurrency().getName());
            System.out.println("Date and Time in that country: " + getGeolocation().getTimezone().getCurrentTime());
        } else {
            System.out.printf("Status Code: %d, Message: %s\n", getGeolocation().getStatus(), getGeolocation().getMessage());
        }

    }
//  when called, stores specific Country data gotten from the API in the country Class
    public void storeTheCountryDataInTheCountryClass(){
        getCountry().setContinent(getGeolocation().getContinentName());
        getCountry().setCountryCode(getGeolocation().getCountryCode3());
        getCountry().setCurrency(getGeolocation().getCurrency().getName());
        getCountry().setName(getGeolocation().getCountryName());
    }

    public io.ipgeolocation.api.Geolocation getGeolocation() {
        return geolocation;
    }

    public String getIpAddressInUse() {
        return ipAddressInUse;
    }

    public void setIpAddressInUse(String ipAddressInUse) {
        this.ipAddressInUse = ipAddressInUse;
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
