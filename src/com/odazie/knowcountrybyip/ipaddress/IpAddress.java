package com.odazie.knowcountrybyip.ipaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class IpAddress {
    private String hostname;
    private InetAddress inetAddress;
    private String publicIpAddress;

    public IpAddress(){
        this.hostname = null;
        this.inetAddress = null;
        this.publicIpAddress = "";
    }

    public void printDetails(){
        try {
            this.setInetAddress(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Hostname: " + getHostname());
        System.out.println("Local IP Address: " + getInetAddress().getHostAddress()); // Local IP Address
//        System.out.println("TestIP Address: " + InetAddress.getLoopbackAddress()); // LocalHost address
    }

    // This method gets public Ip address of Device.
    public void   getPublicIpAddressOfDevice(){
        URL url_name = null;
        try {
            url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader scanner = new BufferedReader(new InputStreamReader(url_name.openStream()));

            this.setPublicIpAddress(scanner.readLine().trim());
        } catch (IOException e) {
            this.setPublicIpAddress("Cannot Execute properly");
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Public(InternetConnectivity) Address: " + getPublicIpAddress());

    }


    public String getPublicIpAddress() {
        return publicIpAddress;
    }

    public void setPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    public String getHostname() {
        return getInetAddress().getHostName();
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }
}
