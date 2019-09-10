package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserDAO;
import model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	UserDAO userDAO = new UserDAO();
	
	public UserController() {
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// me pasan login y passwrd y hasgo consulta a bd para verificar si exsite un
		// usuario con eso
		// si existe login correcto
		// si no fallo
		// busqueda por parametros

		User user = new User();
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		 

		if (userDAO.login(user) == true) {
			
			request.setAttribute("NOTIFICATION", "User Find Successfully!");
			dispatcher = request.getRequestDispatcher("/views/NewFile.jsp");
			dispatcher.forward(request, response);
			
		} else {
				request.setAttribute("NOTIFICATION", "Error, user not found!");
				dispatcher = request.getRequestDispatcher("/views/Register.jsp");
				dispatcher.forward(request, response);
			}

	}
	

}
