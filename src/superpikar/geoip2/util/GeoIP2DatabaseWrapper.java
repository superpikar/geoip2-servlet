package superpikar.geoip2.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.FileSystem;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import superpikar.geoip2.model.IpAddressLocation;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeoIP2DatabaseWrapper {
	private final String DATABASE = "/resources/GeoLite2-City.mmdb";
	private InputStream database;
	
	public GeoIP2DatabaseWrapper(ServletContext servletContext) throws IOException{
		database = servletContext.getResourceAsStream(DATABASE);
	}
	
	public ArrayList<IpAddressLocation> getAddress(ArrayList<IpAddressLocation> ips) {
		ArrayList<IpAddressLocation> ipAddressLocations = new ArrayList<IpAddressLocation>();
		DatabaseReader reader;
		try {
			reader = new DatabaseReader.Builder(database).build();
			for(IpAddressLocation loc : ips){
				InetAddress ipAddress = InetAddress.getByName(loc.getIPAddress());
				CityResponse response = reader.city(ipAddress);
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
