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

@WebServlet("/login/")
public class Connect <T> extends HttpServlet{

	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		try {
			User<T> lu = DaoFactory.getInstance().getUserDao().getLoginUser(email, pwd);
			DaoBddHelper<T> daoBddHelper = new DaoBddHelper<T>();
			daoBddHelper.setCurrentUser(lu);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
