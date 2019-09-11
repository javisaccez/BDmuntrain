package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Question;



public class QuestionDAO {
	

	public List<Question> get() {
				
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			TypedQuery<Question> namedQuery = manager.createNamedQuery("Question.findAll", Question.class);
			List<Question> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Question>();
	}

	public Question get(int id) {
		Question question = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			question = manager.find(Question.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return question;
	}


	public boolean save(Question question) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();   
			manager.persist(question); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean delete(int id) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();   
			Question question = manager.find(Question.class, id);
			if (question != null) {
				manager.remove(question);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	public boolean update(Question question) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.merge(question); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


}
