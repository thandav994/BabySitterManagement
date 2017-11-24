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
	public ArrayList<Appointment> getListOfAppointments(BabySitter user) {

		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		Query<AppointmentEntity> query = session.createQuery("from AppointmentEntity app where app.babysitter.login.user_id =:sitterID");
		query.setParameter("sitterID", user.getEmail());
		List<AppointmentEntity> appointments = query.getResultList();

		session.close();
		sessionFactory.close();
		
		if (appointments != null) {
			ArrayList<Appointment> list = new ArrayList<Appointment>();
			for (int i = 0; i < appointments.size(); i++) {
				AppointmentEntity cur = appointments.get(0);
				Appointment app = new Appointment();
				app.setId(cur.getId());
				app.setStatus(getAppointmentStatus(cur.getStatus()));
				app.setAppointmentDate(cur.getDate().toString());
				
				ParentEntity curParent = cur.getParent();
				Parent p = new Parent();
				p.setAddress(curParent.getAddress());
				p.setBirthday(curParent.getDateOfBirth().toString());
				//p.setEmail(curParent.getEmail());
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
}
