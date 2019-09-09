package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	RequestDispatcher dispatcher = null;
	UserDAO userDAO = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void getSingleUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// me pasan login y passwrd y hasgo consulta a bd para verificar si exsite un usuario con eso
		// si existe login correcto
		// si no fallo 
		// busqueda por parametros
		
		

		User user = new User();
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		

		/*
		 * if (theList.contains(user)) { request.setAttribute("NOTIFICATION",
		 * "User Find Successfully!"); dispatcher =
		 * request.getRequestDispatcher("/views/NewFile.jsp");
		 * dispatcher.forward(request, response); } else { dispatcher =
		 * request.getRequestDispatcher("/views/Register.jsp");
		 * dispatcher.forward(request, response);
		 * 
		 * }
		 */

		
		  if (userDAO.login(user) == null) { 
			  dispatcher = request.getRequestDispatcher("/views/Register.jsp");
			  dispatcher.forward(request, response); 
		  } else {
			  request.setAttribute("NOTIFICATION", "User Find Successfully!"); dispatcher =
			request.getRequestDispatcher("/views/NewFile.jsp");
			  dispatcher.forward(request, response); 
		  }
		 

		/*
		 * if (id.isEmpty() || id == null)
		 * 
		 * { dispatcher = request.getRequestDispatcher("/views/Register.jsp");
		 * dispatcher.forward(request, response);
		 * 
		 * } else { request.setAttribute("NOTIFICATION", "User Find Successfully!");
		 * dispatcher = request.getRequestDispatcher("/views/NewFile.jsp");
		 * dispatcher.forward(request, response); }
		 */
		
		

	}

}
