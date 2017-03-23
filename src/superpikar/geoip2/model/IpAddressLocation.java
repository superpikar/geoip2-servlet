package superpikar.geoip2.model;

import java.util.List;

import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;
import com.maxmind.geoip2.record.Traits;

public class IpAddressLocation {
	private String organizationName;
	private String IPAddress;
	private Country country;
	private Subdivision subdivision;
	private City city;
	private Postal postal;
	private Location location;
	private Traits traits;
	
	public IpAddressLocation(String IPAddress, String organizationName){
		setOrganizationName(organizationName);
		setIPAddress(IPAddress);
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Postal getPostal() {
		return postal;
	}
	public void setPostal(Postal postal) {
		this.postal = postal;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Subdivision getSubdivision() {
		return subdivision;
	}
	public void setSubdivision(Subdivision subdivision) {
		this.subdivision = subdivision;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getIPAddress() {
		return IPAddress;
	}

	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	public Traits getTraits() {
		return traits;
	}

	public void setTraits(Traits traits) {
		this.traits = traits;
	}
}
