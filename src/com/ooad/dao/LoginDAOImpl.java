package com.ooad.dao;

import java.math.BigInteger;
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

import com.ooad.beans.BabySitter;
import com.ooad.beans.Login;
import com.ooad.beans.Parent;
import com.ooad.beans.User;
import com.ooad.entities.BabySitterEntity;
import com.ooad.entities.LoginEntity;
import com.ooad.entities.ParentEntity;

public class LoginDAOImpl implements LoginDAO{
	
	private void addUser(User user, Session session) throws ParseException {
		LoginEntity login = new LoginEntity();
		login.setUser_id(user.getEmail());
		login.setPass(user.getPassword());
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(login);
		tx.commit();
	}

	public void addBabySitter(BabySitter babysitter) throws ParseException {
		// TODO Auto-generated method stub	
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		addUser(babysitter, session);
		
		try {
			BabySitterEntity sitter = new BabySitterEntity();
			sitter.setFirstName(babysitter.getFirstName());
			sitter.setLastName(babysitter.getLastName());
			sitter.setGender(babysitter.getGender());
			
			Date dateOfBirth = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(babysitter.getBirthday());
			sitter.setDateOfBirth(dateOfBirth);
			sitter.setHourlypay(babysitter.getHourlypay());
			sitter.setBio(babysitter.getBio());
			sitter.setExperience(babysitter.getExperience());
			sitter.setAddress(babysitter.getAddress());
			sitter.setPhone(BigInteger.valueOf(Long.parseLong(babysitter.getPhone())));
			sitter.setZipcode(babysitter.getZipcode());
			sitter.setSsn(babysitter.getSsn());
			
			
			LoginEntity login = session.get(LoginEntity.class, babysitter.getEmail());
			sitter.setLogin(login);
			
			session.save(sitter);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		} 
		catch(Exception e) {
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

	public void addParent(Parent parent) throws ParseException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		try {
			addUser(parent, session);
			ParentEntity parentEntity = new ParentEntity();
			
			parentEntity.setFirstName(parent.getFirstName());
			parentEntity.setLastName(parent.getLastName());
			parentEntity.setGender(parent.getGender());
			
			Date dateOfBirth = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(parent.getBirthday());
			parentEntity.setDateOfBirth(dateOfBirth);
			parentEntity.setAddress(parent.getAddress());
			parentEntity.setPhone(BigInteger.valueOf(Long.parseLong(parent.getPhone())));
			parentEntity.setZipcode(parent.getZipcode());
			parentEntity.setSpecial_requests(parent.getSpecial_requests());
			
			LoginEntity login = session.get(LoginEntity.class, parent.getEmail());
			parentEntity.setLogin(login);
			
			session.save(parentEntity);
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		} 
		catch(Exception e) {
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

//	public boolean isExistingUser(User user) {
//		// TODO Auto-generated method stub
//		
//		boolean isExisting = false;
//		SessionFactory sessionFactory = new Configuration()
//	               .configure("hibernate.cfg.xml").buildSessionFactory();
//		
//		Session session = sessionFactory.openSession();
//		
//		session.beginTransaction();
//		// Checking if the category is right
//		if(user.getCategory().equals("babysitter")) {
//			@SuppressWarnings("unchecked")
//			Query<BabySitterEntity> query1 = session.createQuery("from BabySitterEntity sitter where sitter.login.user_id = :userId");
//	        query1.setParameter("userId", user.getEmail());
//			List<BabySitterEntity> sitters = query1.getResultList();
//			
//			// Setting all the details in the object if it is an existing user
//			if(!sitters.isEmpty()) {
//				BabySitterEntity sitter = sitters.get(0);
//				isExisting= true;
//				user.setFirstName(sitter.getFirstName());
//				user.setLastName(sitter.getLastName());
//				user.setBirthday(sitter.getDateOfBirth().toString());
//				user.setGender(sitter.getGender());
//			}
//		} else {
//			@SuppressWarnings("unchecked")
//			Query<ParentEntity> query2 = session.createQuery("from ParentEntity parent where parent.login.user_id = :userId");
//	        query2.setParameter("userId", user.getEmail());
//			List<ParentEntity> parents = query2.getResultList();
//			if(!parents.isEmpty()) {
//				ParentEntity parent = parents.get(0);
//				isExisting= true;
//				user.setFirstName(parent.getFirstName());
//				user.setLastName(parent.getLastName());
//				user.setBirthday(parent.getDateOfBirth().toString());
//				user.setGender(parent.getGender());
//			}
//		}
//		
//		// Checking if the password is right
//		LoginEntity loginEntity = session.get(LoginEntity.class, user.getEmail());
//		if(loginEntity !=null) {
//			if(!loginEntity.getPass().contentEquals(user.getPassword())) {
//				isExisting= false;
//			}
//		}
//		
//		session.close();
//		sessionFactory.close();
//
//		return isExisting;
//	}
	
	public Login isExistingParent(Parent parent) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		// Checking if the category is right
		@SuppressWarnings("unchecked")
		Query<ParentEntity> query2 = session.createQuery("from ParentEntity parent where parent.login.user_id = :userId");
        query2.setParameter("userId", parent.getEmail());
		List<ParentEntity> parents = query2.getResultList();
		if(!parents.isEmpty()) {
			ParentEntity parentEntity = parents.get(0);
			parent.setFirstName(parentEntity.getFirstName());
			parent.setLastName(parentEntity.getLastName());
			parent.setBirthday(parentEntity.getDateOfBirth().toString());
			parent.setGender(parentEntity.getGender());
			parent.setAddress(parentEntity.getAddress());
			parent.setPhone(parentEntity.getPhone().toString());
			parent.setSpecial_requests(parentEntity.getSpecial_requests());
			parent.setZipcode(parentEntity.getZipcode());
		}
		
		// Checking if the password is right
		LoginEntity loginEntity = session.get(LoginEntity.class, parent.getEmail());
		Login login = null ;
		if(loginEntity !=null) {
			login = new Login();
			login.setPassword(loginEntity.getPass());
		}
		session.close();
		sessionFactory.close();

		return login;
	}
	
	public Login isExistingSitter(BabySitter sitter) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		// Checking if the category is right
		@SuppressWarnings("unchecked")
		Query<BabySitterEntity> query2 = session.createQuery("from BabySitterEntity sitter where sitter.login.user_id = :userId");
        query2.setParameter("userId", sitter.getEmail());
		List<BabySitterEntity> sitters = query2.getResultList();
		if(!sitters.isEmpty()) {
			BabySitterEntity sitterEntity = sitters.get(0);
			sitter.setFirstName(sitterEntity.getFirstName());
			sitter.setLastName(sitterEntity.getLastName());
			sitter.setBirthday(sitterEntity.getDateOfBirth().toString());
			sitter.setGender(sitterEntity.getGender());
			sitter.setAddress(sitterEntity.getAddress());
			sitter.setPhone(sitterEntity.getPhone().toString());
			sitter.setZipcode(sitterEntity.getZipcode());
			sitter.setExperience(sitterEntity.getExperience());
			sitter.setBio(sitterEntity.getBio());
			sitter.setHourlypay(sitterEntity.getHourlypay());
			sitter.setSsn(sitterEntity.getSsn());
		}
		
		// Checking if the password is right
		LoginEntity loginEntity = session.get(LoginEntity.class, sitter.getEmail());
		Login login = null ;
		if(loginEntity !=null) {
			login = new Login();
			login.setPassword(loginEntity.getPass());
		}
		session.close();
		sessionFactory.close();

		return login;
	}
}
