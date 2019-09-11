package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExamtemplateDAO;
import model.Examtemplate;

	
	@WebServlet("/ExamtemplateController")
	public class ExamtemplateController extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		
		RequestDispatcher dispatcher = null;
		ExamtemplateDAO examtemplateDAO = new ExamtemplateDAO();
		
		public ExamtemplateController() {
			examtemplateDAO = new ExamtemplateDAO();
			
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String action = request.getParameter("action");
			
			if(action == null) {
				action = "LIST";
			}
		/* do { */
				
		
				switch(action) {
						
					
					case "LIST":
						listExamtemplate(request, response);
						break;
						
					case "EDIT":
						getSingleExamtemplate(request, response);
						break;
						
					case "DELETE":
						deleteExamtemplate(request, response);
						break;
					
					/*case "PUBLISH":
						publishExamtemplate(request, response);*/
						
					default:
						listExamtemplate(request, response);
						break;
						
				}
			/*}while(action!="PUBLISH");*/
			
		}


		private void deleteExamtemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("id");
		
			if(examtemplateDAO.delete(Integer.parseInt(id))) {
				request.setAttribute("NOTIFICATION", "Examtemplate Deleted Successfully!");
			}
			
			listExamtemplate(request, response);
		}

		private void getSingleExamtemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			String id = request.getParameter("id");
			
			Examtemplate theExamtemplate = examtemplateDAO.get(Integer.parseInt(id));
			
			request.setAttribute("examtemplate", theExamtemplate);
			
			dispatcher = request.getRequestDispatcher("/views/question-list.jsp");
			
			dispatcher.forward(request, response);
		}

		private void listExamtemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			List<Examtemplate> theList = examtemplateDAO.get();
			
			request.setAttribute("list", theList);

			dispatcher = request.getRequestDispatcher("/views/examtemplate-list.jsp");
			
			dispatcher.forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("id");
			
			Examtemplate examtemplate = new Examtemplate();
			examtemplate.setDescriptionET(request.getParameter("descriptionET"));
			
			if(id.isEmpty() || id == null) {
				
				if(examtemplateDAO.save(examtemplate)) {
					request.setAttribute("NOTIFICATION", "Examtemplate Saved Successfully!");
				}	
			}else {	
				examtemplate.setId(Integer.parseInt(id));
				if(examtemplateDAO.update(examtemplate)) {
					request.setAttribute("NOTIFICATION", "Examtemplate Updated Successfully!");
				}	
			}
			listExamtemplate(request, response);
		}



}
