package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ResponsesDAO;
import model.Responses;

@WebServlet("/ResponsesController")
public class ResponsesController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	ResponsesDAO responsesDAO = new ResponsesDAO();
	
	public ResponsesController() {
		responsesDAO = new ResponsesDAO();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
				
			
			case "LIST":
				listResponses(request, response);
				break;
				
			case "EDIT":
				getSingleResponses(request, response);
				break;
				
			case "DELETE":
				deleteResponses(request, response);
				break;
				
			default:
				listResponses(request, response);
				break;
				
		}
		
	}

	private void deleteResponses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(responsesDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Responses Deleted Successfully!");
		}
		
		listResponses(request, response);
	}

	private void getSingleResponses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Responses theResponses = responsesDAO.get(Integer.parseInt(id));
		
		request.setAttribute("responses", theResponses);
		
		dispatcher = request.getRequestDispatcher("/views/question-list.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listResponses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Responses> theList = responsesDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/responses-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Responses responses = new Responses();
		responses.setDescriptionR(request.getParameter("descriptionR"));
		
		if(id.isEmpty() || id == null) {
			
			if(responsesDAO.save(responses)) {
				request.setAttribute("NOTIFICATION", "Responses Saved Successfully!");
			}	
		}else {	
			responses.setId(Integer.parseInt(id));
			if(responsesDAO.update(responses)) {
				request.setAttribute("NOTIFICATION", "Responses Updated Successfully!");
			}	
		}
		listResponses(request, response);
	}



}
