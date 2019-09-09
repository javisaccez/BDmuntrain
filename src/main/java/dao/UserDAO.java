package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import model.User;

public class UserDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
	EntityManager manager = emf.createEntityManager();
	User user = null;

	public User login(User user) {
		
		user = null;

		try {
			
			String jpql = "SELECT u FROM User p WHERE u.login = :login AND u.password = :precio ";
			Query query = manager.createQuery(jpql);
			query.s("login",  );
			query.setParameter("password", );
		    
		    user = query.getSingleResult();
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public User get (int id) {
		User user = null;
		try {
			user = manager.find(User.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean save(User user) {
		boolean flag = false;
		try {
			manager.getTransaction().begin();   
			manager.persist(user); 
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
			
			manager.getTransaction().begin();   
			User user = manager.find(User.class, id);
			if (user != null) {
				manager.remove(user);
				manager.getTransaction().commit(); 
				flag = true;
			}
			manager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(User user) {
		boolean flag = false;
		try {
			manager.getTransaction().begin();   
			manager.merge(user); 
			manager.getTransaction().commit(); 
			manager.close();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


	/*
	 * public boolean login() {
	 * 
	 * //User user = new User(); boolean val = false; try { EntityManagerFactory emf
	 * = Persistence.createEntityManagerFactory("BDmuntrain"); EntityManager manager
	 * = emf.createEntityManager(); val = manager.contains(User); manager.close();
	 * }catch(Exception e) { e.printStackTrace(); } return val; }
	 */
}
