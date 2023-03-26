package fr.pau.univ.meetballs.servlets;

import java.io.IOException;
import java.util.List;

import fr.pau.univ.meetballs.dao.DaoFactory;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main/")
public class ToMatchUsers<T> extends HttpServlet{
	
	private List<User<T>> toTrial;
	private int userAtIndex = 0;
	
	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("users", DaoFactory.getInstance().getUserDao().getToMatchUser());
		} catch (DaoException e) {
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}
	
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		userAtIndex++;
	}
}
