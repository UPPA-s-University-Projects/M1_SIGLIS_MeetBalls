package fr.pau.univ.meetballs.servlets;

import java.io.IOException;
import java.rmi.ServerException;

import fr.pau.univ.meetballs.dao.DaoFactory;
import fr.pau.univ.meetballs.dao.impl.bdd.DaoBddHelper;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signUp/")
public class Signup  extends HttpServlet{

	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String fname = request.getParameter("fname");
		String handle = request.getParameter("handle");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String bio = request.getParameter("bio");
		String loc = request.getParameter("loc");
		String perimeter = request.getParameter("perimeter");
		String desert = request.getParameter("desert");
		
		
		
		try {
//			User<T> lu = DaoFactory.getInstance().getUserDao().getLoginUser(email, pwd);
//			DaoBddHelper<T> daoBddHelper = new DaoBddHelper<T>();
//			daoBddHelper.setCurrentUser(lu);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
