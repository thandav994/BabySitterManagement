package com.ooad.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ooad.beans.Appointment;
import com.ooad.beans.AppointmentStatus;
import com.ooad.beans.User;
import com.ooad.entities.BabySitterEntity;
import com.ooad.entities.LoginEntity;
import com.ooad.entities.AppointmentEntity;
import com.ooad.entities.ParentEntity;

public class BabysitterDAO {
	
	public Appointment[] GetListOfAppointments(User user) throws ParseException {
		
	}
	
	public void UpdateBabySitterApproval(Appointment appointment, Boolean approval) {
		
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
		
		session.close();
		sessionFactory.close();

	}

}
