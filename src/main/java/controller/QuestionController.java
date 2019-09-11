package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import model.Question;

@WebServlet("/QuestionController")
public class QuestionController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	QuestionDAO questionDAO = new QuestionDAO();
	
	public QuestionController() {
		questionDAO = new QuestionDAO();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
				
			
			case "LIST":
				listQuestion(request, response);
				break;
				
			case "EDIT":
				getSingleQuestion(request, response);
				break;
				
			case "DELETE":
				deleteQuestion(request, response);
				break;
				
			default:
				listQuestion(request, response);
				break;
				
		}
		
	}

	private void deleteQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(questionDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Question Deleted Successfully!");
		}
		
		listQuestion(request, response);
	}

	private void getSingleQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Question theQuestion = questionDAO.get(Integer.parseInt(id));
		
		request.setAttribute("question", theQuestion);
		
		dispatcher = request.getRequestDispatcher("/views/question-list.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Question> theList = questionDAO.get();
		
		request.setAttribute("list", theList);

		dispatcher = request.getRequestDispatcher("/views/question-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Question question = new Question();
		question.setDescription(request.getParameter("description"));
		
		if(id.isEmpty() || id == null) {
			
			if(questionDAO.save(question)) {
				request.setAttribute("NOTIFICATION", "Question Saved Successfully!");
			}	
		}else {	
			question.setId(Integer.parseInt(id));
			if(questionDAO.update(question)) {
				request.setAttribute("NOTIFICATION", "Question Updated Successfully!");
			}	
		}
		listQuestion(request, response);
	}



}
