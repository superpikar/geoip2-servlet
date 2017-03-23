package superpikar.geoip2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import superpikar.geoip2.model.IpAddressLocation;
import superpikar.geoip2.util.CSVParser;
import superpikar.geoip2.util.GeoIP2DatabaseWrapper;
import superpikar.geoip2.util.GeoIP2PrecisionWrapper;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();
		GeoIP2PrecisionWrapper geoIp2Precision = new GeoIP2PrecisionWrapper(ctx);
		GeoIP2DatabaseWrapper geoIp2Database = new GeoIP2DatabaseWrapper(ctx);
		
		// IP Address taken from http://tools.tracemyip.org/search--ip		
		ArrayList<IpAddressLocation> ips = CSVParser.readCSV(ctx, "/resources/ipAddress.csv");
		request.setAttribute("ipAddress", geoIp2Precision.getAddress(ips));
		request.setAttribute("ipAddress2", geoIp2Database.getAddress(ips));
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
