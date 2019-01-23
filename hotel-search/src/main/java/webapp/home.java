package webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/home.html")
public class home extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/home.html").forward(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		getAllHotels hotels_list = new getAllHotels();
		List<String> allhotels = hotels_list.gethotels();
		
		String hotel_name = request.getParameter("hotel_name");
		
		searchHotel name = new searchHotel();
		name.search(hotel_name,allhotels);
		request.setAttribute("filteredhotels", name.filteredhotels);
		
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		
	}
}
