package com.ooad.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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
	public ArrayList<Appointment> getListOfAppointments(BabySitter user) {

		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		List<AppointmentEntity> appointments = (List<AppointmentEntity>) session.createQuery(
				"from babysitters natural join appointments where babysitters.emailID=" 
				+ user.getEmail()).list();
		
		session.close();
		sessionFactory.close();
		
		if (appointments != null) {
			ArrayList<Appointment> list = new ArrayList<Appointment>();
			for (int i = 0; i < appointments.size(); i++) {
				AppointmentEntity cur = appointments.get(0);
				Appointment app = new Appointment();
				app.setId(cur.getId());
				app.setStatus(getAppointmentStatus(cur.getStatus()));
				app.setDate(cur.getDate());
				app.setBabysitterID(cur.getBabysitter().getSitterID());
				app.setParentID(cur.getParent().getParentID());
				list.add(app);
			}
			return list;
		}
		else
			return null;
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
	
	public Parent getParentInfo(int parentID) {
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		ParentEntity parent = session.get(ParentEntity.class, parentID);
		
		session.close();
		sessionFactory.close();
		
		if (parent != null) {
			Parent p = new Parent();
			//TODO Fill data
			return p;
			
		} else {
			return null;
		}
	}
}
