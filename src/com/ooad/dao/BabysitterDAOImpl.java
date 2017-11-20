package com.ooad.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public Appointment[] getListOfAppointments(User user) {

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
			Appointment[] list = new Appointment[appointments.size()];
			for (int i = 0; i < appointments.size(); i++) {
				AppointmentEntity cur = appointments.get(0);
				list[i].setId(cur.getId());
				list[i].setStatus(getAppointmentStatus(cur.getStatus()));
				list[i].setStartDate(cur.getStartDate());
				list[i].setEndDate(cur.getEndDate());
				list[i].setBabysitterID(cur.getBabysitter().getSitterID());
				list[i].setParentID(cur.getParent().getParentID());
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
		
		if(appEntity != null && appEntity.getStatus()==AppointmentStatus.Pending.ordinal()) {
			//Update status
			AppointmentStatus curStatus = appointment.getStatus();
			appEntity.setStatus(curStatus.ordinal());
		}
		
		session.save(appEntity);
		session.getTransaction().commit();
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
