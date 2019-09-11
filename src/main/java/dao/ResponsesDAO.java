package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Responses;

public class ResponsesDAO {

	public List<Responses> get() {
				
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			TypedQuery<Responses> namedQuery = manager.createNamedQuery("Responses.findAll", Responses.class);
			List<Responses> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Responses>();
	}

	public Responses get(int id) {
		Responses responses = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			responses = manager.find(Responses.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responses;
	}


	public boolean save(Responses responses) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();   
			manager.persist(responses); 
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
			Responses responses = manager.find(Responses.class, id);
			if (responses != null) {
				manager.remove(responses);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	public boolean update(Responses responses) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.merge(responses); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
