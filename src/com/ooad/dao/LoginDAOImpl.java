package com.ooad.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ooad.beans.User;
import com.ooad.entities.BabySitterEntity;
import com.ooad.entities.LoginEntity;
import com.ooad.entities.ParentEntity;

public class LoginDAOImpl implements LoginDAO{
	
	public void addUser(User user) throws ParseException {
		LoginEntity login = new LoginEntity();
		login.setUser_id(user.getEmail());
		login.setPass(user.getPassword());
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		Transaction tx = session.getTransaction();
		
		tx.begin();
		
		session.save(login);
		tx.commit();
		
		try {
			if(user.getCategory().contentEquals("parent")) {
				addParent(user);
			}
			else if(user.getCategory().contentEquals("babysitter")) {
				addBabySitter(user);
			}
		}
		catch(Exception e) {
			tx.rollback();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

	private void addBabySitter(User user) throws ParseException {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		BabySitterEntity sitter = new BabySitterEntity();
		sitter.setFirstName(user.getFirstName());
		sitter.setLastName(user.getLastName());
		sitter.setGender(user.getGender());
		
		Date dateOfBirth = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(user.getBirthday());
		sitter.setDateOfBirth(dateOfBirth);
		
		LoginEntity login = session.get(LoginEntity.class, user.getEmail());
		sitter.setLogin(login);
		
		session.save(sitter);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	private void addParent(User user) throws ParseException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		ParentEntity parent = new ParentEntity();
		
		parent.setFirstName(user.getFirstName());
		parent.setLastName(user.getLastName());
		parent.setGender(user.getGender());
		
		Date dateOfBirth = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(user.getBirthday());
		parent.setDateOfBirth(dateOfBirth);
		
		LoginEntity login = session.get(LoginEntity.class, user.getEmail());
		parent.setLogin(login);
		
		session.save(parent);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	public boolean isExistingUser(User user) {
		// TODO Auto-generated method stub
		
		boolean isExisting = false;
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		// Checking if the category is right
		if(user.getCategory().equals("babysitter")) {
			@SuppressWarnings("unchecked")
			Query<BabySitterEntity> query1 = session.createQuery("from BabySitterEntity sitter where sitter.login.user_id = :userId");
	        query1.setParameter("userId", user.getEmail());
			List<BabySitterEntity> sitters = query1.getResultList();
			
			// Setting all the details in the object if it is an existing user
			if(!sitters.isEmpty()) {
				BabySitterEntity sitter = sitters.get(0);
				isExisting= true;
				user.setFirstName(sitter.getFirstName());
				user.setLastName(sitter.getLastName());
				user.setBirthday(sitter.getDateOfBirth().toString());
				user.setGender(sitter.getGender());
			}
		} else {
			@SuppressWarnings("unchecked")
			Query<ParentEntity> query2 = session.createQuery("from ParentEntity parent where parent.login.user_id = :userId");
	        query2.setParameter("userId", user.getEmail());
			List<ParentEntity> parents = query2.getResultList();
			if(!parents.isEmpty()) {
				ParentEntity parent = parents.get(0);
				isExisting= true;
				user.setFirstName(parent.getFirstName());
				user.setLastName(parent.getLastName());
				user.setBirthday(parent.getDateOfBirth().toString());
				user.setGender(parent.getGender());
			}
		}
		
		// Checking if the password is right
		LoginEntity loginEntity = session.get(LoginEntity.class, user.getEmail());
		if(loginEntity !=null) {
			if(!loginEntity.getPass().contentEquals(user.getPassword())) {
				isExisting= false;
			}
		}
		
		session.close();
		sessionFactory.close();

		return isExisting;
	}
}
