package fr.pau.univ.meetballs.servlets;

import java.io.IOException;

import fr.pau.univ.meetballs.dao.DaoFactory;
import fr.pau.univ.meetballs.exception.DaoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main/")
public class ToMatchUsers extends HttpServlet{
	
	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		//TODO: find a way to implement this servlet.
		//It is the core part of our system thus very important!

//		try {
//			request.setAttribute("users", DaoFactory.getInstance().getUserDao().getToMatchUser());
//		} catch (DaoException e) {
//			request.setAttribute("erreur", e.getMessage());
//			e.printStackTrace();
//		}
//		this.getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
	}
}
