package com.ooad.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ooad.beans.Appointment;
import com.ooad.beans.AppointmentStatus;
import com.ooad.beans.BabySitter;
import com.ooad.beans.Parent;
import com.ooad.entities.AppointmentEntity;
import com.ooad.entities.BabySitterEntity;
import com.ooad.entities.ParentEntity;
import com.ooad.entities.ReviewsEntity;

public class ParentsFunctionalityDAOImpl implements ParentsFunctionalityDAO {
	
	public ArrayList<BabySitter> getListofBabySitters(String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		Query<BabySitterEntity> query = session.createQuery("from BabySitterEntity sitter where sitter.sitterID not in (select a.babysitter.sitterID from AppointmentEntity a where a.startDate =:date)");
		Date appointmentDateFormatted = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(appointmentDate);
		query.setParameter("date", appointmentDateFormatted);
		
//		Criteria criteria = session.createCriteria(BabySitterEntity.class);
//		if (appointmentDate != null) {
//		    criteria.add(Expression.eq("category", category);
//		}
//		// And so on...
//		List<BabySitterEntity> results = criteria.list();
		
		
		List<BabySitterEntity> sitterEntitiesList = query.getResultList();
		ArrayList<BabySitter> sitterslist = new ArrayList<>();
		for(BabySitterEntity each : sitterEntitiesList) {
			BabySitter sitter = new BabySitter();			
			sitter.setAddress(each.getAddress());
			sitter.setBio(each.getBio());
			sitter.setdateofBirth(each.getDateOfBirth().toString());
			sitter.setEmail(each.getLogin().getUser_id());
			sitter.setExperience(each.getExperience());
			sitter.setFirstName(each.getFirstName());
			sitter.setGender(each.getGender());
			sitter.setHourlyPay(each.getHourlypay());
			sitter.setLastName(each.getLastName());
			sitter.setPhone(each.getPhone().toString());
			sitter.setSsn(each.getSsn());
			sitter.setZipcode(each.getZipcode());
			sitterslist.add(sitter);
		}
		session.close();
		
		return sitterslist;
	}

	@SuppressWarnings("unchecked")
	public BabySitter getSitterInformation(String sitterID) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		BabySitter sitter = null;
		try {
			Query<BabySitterEntity> query = session.createQuery("from BabySitterEntity b where b.login.user_id =:sitterID");
			query.setParameter("sitterID", sitterID);
			BabySitterEntity babysitterEntity = query.getSingleResult();
			
			sitter = new BabySitter();
			sitter.setAddress(babysitterEntity.getAddress());
			sitter.setBio(babysitterEntity.getBio());
			sitter.setdateofBirth(babysitterEntity.getDateOfBirth().toString());
			sitter.setEmail(babysitterEntity.getLogin().getUser_id());
			sitter.setExperience(babysitterEntity.getExperience());
			sitter.setFirstName(babysitterEntity.getFirstName());
			sitter.setGender(babysitterEntity.getGender());
			sitter.setHourlyPay(babysitterEntity.getHourlypay());
			sitter.setLastName(babysitterEntity.getLastName());
			sitter.setPhone(babysitterEntity.getPhone().toString());
			sitter.setSsn(babysitterEntity.getSsn());
			sitter.setZipcode(babysitterEntity.getZipcode());
			sitter.setRating(babysitterEntity.getReview().getRating());
			session.close();
			return sitter;
		}
		catch(Exception e) {
			session.close();
			return sitter;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean bookAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration()
		               .configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			AppointmentEntity appointmentEntity = new AppointmentEntity();
			Date appointmentDateFormatted = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(appointment.getAppointmentDate());
			appointmentEntity.setDate(appointmentDateFormatted);
			
			Query<BabySitterEntity> query = session.createQuery("from BabySitterEntity b where b.login.user_id =:sitterID");
			query.setParameter("sitterID", appointment.getSitter().getEmail());
			BabySitterEntity babysitter = query.getSingleResult();
			appointmentEntity.setBabysitter(babysitter);
			
			Query<ParentEntity> query2 = session.createQuery("from ParentEntity b where b.login.user_id =:parentID");
			query2.setParameter("parentID", appointment.getParent().getEmail());
			ParentEntity parentEntity = query2.getSingleResult();
			appointmentEntity.setParent(parentEntity);
			appointmentEntity.setStatus(AppointmentStatus.Pending.ordinal());
			session.save(appointmentEntity);
			
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public ArrayList<Appointment> getAppointmentsList(Parent parent){
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		Query<AppointmentEntity> query = session.createQuery("from AppointmentEntity app where app.parent.login.user_id =:parentID");
		query.setParameter("parentID", parent.getEmail());
		List<AppointmentEntity> appointmentEntities = query.getResultList();
		ArrayList<Appointment> appointments = new ArrayList<>();
		for(AppointmentEntity eachAppointment : appointmentEntities) {
			Appointment appointment = new Appointment();
			appointment.setId(eachAppointment.getId());
			appointment.setAppointmentDate(eachAppointment.getDate().toString());
			appointment.setStatus(AppointmentStatus.values()[eachAppointment.getStatus()]);
			
			BabySitterEntity babysitterEntity = eachAppointment.getBabysitter();
			BabySitter sitter = new BabySitter();
			sitter.setAddress(babysitterEntity.getAddress());
			sitter.setBio(babysitterEntity.getBio());
			sitter.setdateofBirth(babysitterEntity.getDateOfBirth().toString());
			sitter.setEmail(babysitterEntity.getLogin().getUser_id());
			sitter.setExperience(babysitterEntity.getExperience());
			sitter.setFirstName(babysitterEntity.getFirstName());
			sitter.setGender(babysitterEntity.getGender());
			sitter.setHourlyPay(babysitterEntity.getHourlypay());
			sitter.setLastName(babysitterEntity.getLastName());
			sitter.setPhone(babysitterEntity.getPhone().toString());
			sitter.setSsn(babysitterEntity.getSsn());
			sitter.setZipcode(babysitterEntity.getZipcode());
			
			appointment.setSitter(sitter);
			
			appointments.add(appointment);
		}
		session.close();
		return appointments;
	}

	public boolean cancelAppointment(Integer appointmentID) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			Query<AppointmentEntity> query = session.createQuery("delete AppointmentEntity app where app.id =: appointmentID");
			query.setParameter("appointmentID", appointmentID);
			int result = query.executeUpdate();
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			return false;
		}	
	}
	
	public void saveAppointment(Appointment appointment) {
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		AppointmentEntity appEntity = session.get(AppointmentEntity.class, appointment.getId());
		AppointmentStatus curStatus = appointment.getStatus();
		
		if(appEntity != null && appEntity.getStatus()!=curStatus.ordinal()) {
			//Update status
			appEntity.setStatus(curStatus.ordinal());
			session.save(appEntity);
			session.getTransaction().commit();
		}

		session.close();
		sessionFactory.close();
	}

	@SuppressWarnings("finally")
	public boolean rateaSitter(Parent parent, BabySitter sitter, Integer rating) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		boolean success = false;
		
		try {
		ReviewsEntity review = new ReviewsEntity();
		review.setRating(rating);
		
		@SuppressWarnings("unchecked")
		Query<ParentEntity> query = session.createQuery("from ParentEntity p where p.login.user_id =:parentID");
		query.setParameter("parentID", parent.getEmail());
		ParentEntity parentEntity = query.getSingleResult();
		review.setParent(parentEntity);
		
		@SuppressWarnings("unchecked")
		Query<BabySitterEntity> query2 = session.createQuery("from BabySitterEntity b where b.login.user_id =:sitterID");
		query.setParameter("sitterID", sitter.getEmail());
		BabySitterEntity sitterEntity = query2.getSingleResult();
		review.setBabysitter(sitterEntity);
		
		session.save(review);
		
		session.getTransaction().commit();
		success = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			sessionFactory.close();
			return success;
		}
	}
	
}
