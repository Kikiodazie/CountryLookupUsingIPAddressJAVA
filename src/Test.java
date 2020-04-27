import com.odazie.knowcountrybyip.geolocation.Geolocation;


public class Test {
    public static void main(String[] args) {
        Geolocation geolocation = new Geolocation(); // Instance of the Geolocation class
        /* calls a method to know IP address and get location by country of host device
        *  or search with an External ip address of another device
        * */
        geolocation.knowCountryByIp();
        geolocation.storeTheCountryDataInTheCountryClass(); // stores specific Country data gotten from the API in the country Class
        geolocation.getIpAddress().getPublicIpAddressOfDevice();// Get Ip Address of Host Device


    }
}
