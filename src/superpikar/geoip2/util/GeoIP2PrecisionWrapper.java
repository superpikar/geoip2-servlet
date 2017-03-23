package superpikar.geoip2.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.yaml.snakeyaml.Yaml;

import superpikar.geoip2.model.IpAddressLocation;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeoIP2PrecisionWrapper {
	private final String CONFIGPROP = "/resources/config.properties";
	private int userId;
	private String licenseKey;
	
	public GeoIP2PrecisionWrapper(ServletContext servletContext) throws IOException{
		Properties prop = new Properties();
		prop.load(servletContext.getResourceAsStream(CONFIGPROP));
		userId = Integer.parseInt(prop.getProperty("userId"));
		licenseKey = prop.getProperty("licenseKey");
	}
	
	public ArrayList<IpAddressLocation> getAddress(ArrayList<IpAddressLocation> ips) {
		ArrayList<IpAddressLocation> ipAddressLocations = new ArrayList<IpAddressLocation>();
		
		try (WebServiceClient client = new WebServiceClient.Builder(userId, licenseKey)
        .build()) {
			for(IpAddressLocation loc : ips){
				InetAddress ipAddress = InetAddress.getByName(loc.getIPAddress());
				CityResponse response = client.city(ipAddress);
				IpAddressLocation ipAddressLocation = new IpAddressLocation(loc.getIPAddress(), loc.getOrganizationName());
		        ipAddressLocation.setCity(response.getCity());
		        ipAddressLocation.setCountry(response.getCountry());
		        ipAddressLocation.setLocation(response.getLocation());
		        ipAddressLocation.setPostal(response.getPostal());
		        ipAddressLocation.setSubdivision(response.getMostSpecificSubdivision());
		        ipAddressLocation.setTraits(response.getTraits());
		        ipAddressLocations.add(ipAddressLocation);
			}		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeoIp2Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipAddressLocations;
	}
}
