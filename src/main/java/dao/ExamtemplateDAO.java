package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Examtemplate;

public class ExamtemplateDAO {
	
	public List<Examtemplate> get() {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			TypedQuery<Examtemplate> namedQuery = manager.createNamedQuery("Examtemplate.findAll", Examtemplate.class);
			List<Examtemplate> results = namedQuery.getResultList();
			manager.close();
			return results;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Examtemplate>();
	}

	public Examtemplate get(int id) {
		Examtemplate examtemplate = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			examtemplate = manager.find(Examtemplate.class, id);
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return examtemplate;
	}


	public boolean save(Examtemplate examtemplate) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.getTransaction().begin();   
			manager.persist(examtemplate); 
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
			Examtemplate examtemplate = manager.find(Examtemplate.class, id);
			if (examtemplate != null) {
				manager.remove(examtemplate);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	public boolean update(Examtemplate examtemplate) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
			manager.merge(examtemplate); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


}
