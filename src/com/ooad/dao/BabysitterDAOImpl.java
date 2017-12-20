package com.ooad.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ooad.beans.*;
import com.ooad.entities.*;

public class BabysitterDAOImpl implements BabysitterDAO {
	
	private AppointmentStatus getAppointmentStatus (int index) {
		AppointmentStatus curStatus;
		if (AppointmentStatus.Accepted.ordinal() == index) {
			curStatus = AppointmentStatus.Accepted;
		} else if (AppointmentStatus.Completed.ordinal() == index) {
			curStatus = AppointmentStatus.Completed;
		} else if (AppointmentStatus.Pending.ordinal() == index) {
			curStatus = AppointmentStatus.Pending;
		} else {
			curStatus = AppointmentStatus.Rejected;
		}
		return curStatus;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Appointment> getListOfAppointments(BabySitter sitter) {

		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		Query<AppointmentEntity> query = session.createQuery("from AppointmentEntity app where app.babysitter.login.user_id =:sitterID");
		query.setParameter("sitterID", sitter.getEmail());
		List<AppointmentEntity> appointments = query.getResultList();

		session.close();
		sessionFactory.close();
		
		if (appointments != null) {
			ArrayList<Appointment> list = new ArrayList<Appointment>();
			for (int i = 0; i < appointments.size(); i++) {
				AppointmentEntity cur = appointments.get(i);
				Appointment app = new Appointment();
				app.setId(cur.getId());
				app.setStatus(getAppointmentStatus(cur.getStatus()));
				app.setAppointmentDate(cur.getDate().toString());
				
				ParentEntity curParent = cur.getParent();
				Parent p = new Parent();
				p.setAddress(curParent.getAddress());
				p.setdateofBirth(curParent.getDateOfBirth().toString());
				p.setEmail(curParent.getLogin().getUser_id());
				p.setFirstName(curParent.getFirstName());
				p.setGender(curParent.getGender());
				p.setLastName(curParent.getLastName());
				p.setPhone(curParent.getPhone().toString());
				p.setZipcode(curParent.getZipcode());
				p.setSpecial_requests(curParent.getSpecial_requests());
				
				app.setParent(p);
				list.add(app);
			}
			return list;
		}
		else
			return null;
	}
	
	public boolean saveAppointment(Appointment appointment) {
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		try {
		AppointmentEntity appEntity = session.get(AppointmentEntity.class, appointment.getId());
			AppointmentStatus curStatus = appointment.getStatus();
			
			appEntity.setStatus(curStatus.ordinal());
			session.saveOrUpdate(appEntity);
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
			sessionFactory.close();
			return false;
		}
	}

	public Parent getParentInformation(String parentID) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		Parent parent = null;
		
		@SuppressWarnings("unchecked")
		Query<ParentEntity> query = session.createQuery("from ParentEntity p where p.login.user_id =:parentID");
		query.setParameter("parentID", parentID);
		ParentEntity parentEntity = query.getSingleResult();
		
		if(parentEntity != null) {
			parent = new Parent();
			parent.setAddress(parentEntity.getAddress());
			parent.setdateofBirth(parentEntity.getDateOfBirth().toString());
			parent.setEmail(parentEntity.getLogin().getUser_id());
			parent.setFirstName(parentEntity.getFirstName());
			parent.setGender(parentEntity.getGender());
			parent.setLastName(parentEntity.getLastName());
			parent.setPhone(parentEntity.getPhone().toString());
			parent.setSpecial_requests(parentEntity.getSpecial_requests());
			parent.setZipcode(parentEntity.getZipcode());
		}

		session.close();
		sessionFactory.close();
		
		return parent;
	}
}
