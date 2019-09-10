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

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	UserDAO userDAO = new UserDAO();
	
	public RegisterController() {
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 
		User userR = new User(); 
		userR.setLogin(request.getParameter("login"));
		userR.setPassword(request.getParameter("password"));
		userR.setEmail(request.getParameter("email"));
		 
		if (userDAO.save(userR)) {
			request.setAttribute("NOTIFICATION1", "User Saved Successfully!");
		}

	}
	
		 
}