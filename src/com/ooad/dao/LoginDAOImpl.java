package com.ooad.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ooad.beans.Login;
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

	public boolean isExistingUser(Login login) {
		// TODO Auto-generated method stub
		
		boolean isExisting = false;
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		LoginEntity loginEntity = session.get(LoginEntity.class, login.getUserID());
		
//		Query<BabySitterEntity> q = session.createQuery("from BabySitterEntity sitter where sitter.userID = :userId");
//        q.setString("userId", login.getUserID());
//		BabySitterEntity sitter = q.getSingleResult();
//		if(sitter != null)
//			isExisting= true;
//		Query<ParentEntity> p = session.createQuery("from ParentEntity parent where parent.userID = :userId");
//        p.setString("userId", login.getUserID());
//		ParentEntity parent = p.getSingleResult();
//		if(parent != null)
//			isExisting = true;
		
		if(loginEntity !=null) {
			if(loginEntity.getPass().contentEquals(login.getPassword())) {
				isExisting= true;
			}
		}
		session.close();
		sessionFactory.close();

		return isExisting;
	}
}
