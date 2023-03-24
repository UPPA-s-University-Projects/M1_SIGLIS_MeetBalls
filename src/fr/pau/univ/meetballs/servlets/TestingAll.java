package fr.pau.univ.meetballs.servlets;

import java.io.IOException;
import java.rmi.ServerException;

import fr.pau.univ.meetballs.dao.DaoFactory;
import fr.pau.univ.meetballs.exception.DaoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testingAll/")
public class TestingAll extends HttpServlet{

	/**
	 * Méthode qui gère les requêtes GET.
	 * 
	 * @param request La requête HTTP
	 * @param response La réponse HTTP
	 * @throws ServletException Si une erreur de servlet survient
	 * @throws IOException Si une erreur d'entrée/sortie survient
	 */
	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServerException, IOException, ServletException {
		try {
			request.setAttribute("users", DaoFactory.getInstance().getUserDao().getAllUsers());
			System.out.println(DaoFactory.getInstance().getUserDao().getAllUsers().get(0).toString());
		} catch (DaoException e) {
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
	}
	
}
