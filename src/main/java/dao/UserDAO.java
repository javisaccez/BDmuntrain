package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.User;

public class UserDAO {

	

	public boolean login (User user) {
		boolean logger = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
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
	

	public boolean save(User user) {
		boolean flag = false;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDmuntrain");
			EntityManager manager = emf.createEntityManager();
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



}
