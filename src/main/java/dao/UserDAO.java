package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.User;

public class UserDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
	EntityManager manager = emf.createEntityManager();

	public boolean login (User user) {
		boolean logger = false;
		try {
			String jpql = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password ";
			Query query = manager.createQuery(jpql);
			query.setParameter("login", user.getLogin());
			query.setParameter("password", user.getPassword());
			query.getSingleResult();
			manager.close();
			logger = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return logger;
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
