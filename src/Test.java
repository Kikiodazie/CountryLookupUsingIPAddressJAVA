import com.odazie.knowcountrybyip.ipaddress.IpAddress;
import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;

public class Test {
    public static void main(String[] args) {
        IpAddress ipAddress = new IpAddress();

        ipAddress.printDetails();
        ipAddress.getPublicIpAddressOfDevice();
        IPGeolocationAPI geolocationAPI = new IPGeolocationAPI("26e6b6ea29a84c52a78cb50c04d6dff5");

        // Get geolocation for IP address (1.1.1.1) and fields (geo, time_zone and currency)
        GeolocationParams geoParams = new GeolocationParams();
        geoParams.setIPAddress(ipAddress.getPublicIpAddress());
        geoParams.setFields("geo,time_zone,currency");

        Geolocation geolocation = geolocationAPI.getGeolocation(geoParams);

// Check if geolocation lookup was successful
        if(geolocation.getStatus() == 200) {
            System.out.println(geolocation.getCountryName());
            System.out.println(geolocation.getCurrency().getName());
            System.out.println(geolocation.getTimezone().getCurrentTime());
        } else {
            System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
        }


    }
}
