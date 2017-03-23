package superpikar.geoip2.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import superpikar.geoip2.model.IpAddressLocation;

public class CSVParser {
	
	/**
	 * read CSV file in servlet, credit : http://www.devmanuals.com/tutorials/java/servlet/TextFileReading.html
	 * @param servletContext
	 * @param fileName
	 */
	public static ArrayList<IpAddressLocation> readCSV(ServletContext servletContext, String fileName){
		ArrayList<IpAddressLocation> ipAddressLocations = new ArrayList<IpAddressLocation>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(servletContext.getResourceAsStream(fileName)));
		
		try {
			String word="";
			while((word=br.readLine())!=null){
				String[] strSplit = word.split(",");
				ipAddressLocations.add(new IpAddressLocation(strSplit[0], strSplit[1]));
			}				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipAddressLocations;
	}
}
