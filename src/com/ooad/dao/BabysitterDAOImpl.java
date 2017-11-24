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

import com.ooad.beans.Appointment;
import com.ooad.beans.AppointmentStatus;
import com.ooad.beans.User;
import com.ooad.entities.AppointmentEntity;

public class BabysitterDAOImpl {
	
	public Appointment[] GetListOfAppointments(User user) throws ParseException {

		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<AppointmentEntity> appointments = (List<AppointmentEntity>) session.createQuery(
				"from babysitters natural join appointments where babysitters.emailID=" 
				+ user.getEmail()).list();
		session.close();
		sessionFactory.close();
		
		if (appointments != null)
			return (Appointment[]) appointments.toArray();
		else
			return null;
	}
	
	public void UpdateBabySitterApproval(Appointment appointment, Boolean approval) throws ParseException {
		
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		AppointmentEntity appEntity = session.get(AppointmentEntity.class, appointment.getId());
		
		if(appEntity != null && appEntity.getStatus()==AppointmentStatus.Pending.ordinal()) {
			//Update status
			if(approval) {
				appEntity.setStatus(AppointmentStatus.Accepted.ordinal());
			} else {
				appEntity.setStatus(AppointmentStatus.Rejected.ordinal());
			}
		}
		
		session.save(appEntity);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}
}
