import com.odazie.knowcountrybyip.geolocation.Geolocation;


public class Test {
    public static void main(String[] args) {
        Geolocation geolocation = new Geolocation();

        geolocation.getIpAddress().printDetails();
        geolocation.getIpAddress().getPublicIpAddressOfDevice();

        geolocation.printGeolocationDataOfIpAddress();


    }
}
