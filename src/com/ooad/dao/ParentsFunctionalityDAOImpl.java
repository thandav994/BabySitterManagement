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

import com.ooad.beans.BabySitter;
import com.ooad.entities.AppointmentEntity;
import com.ooad.entities.BabySitterEntity;

public class ParentsFunctionalityDAOImpl implements ParentsFunctionalityDAO {
	
	public ArrayList<BabySitter> getListofBabySitters(String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<BabySitterEntity> query = session.createQuery("from BabySitterEntity sitter where sitter.sitterID not in (select a.babysitter.sitterID from AppointmentEntity a where a.startDate =:date)");
		Date appointmentDateFormatted = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(appointmentDate);
		query.setParameter("date", appointmentDateFormatted);
		List<BabySitterEntity> sitterEntitiesList = query.getResultList();
		ArrayList<BabySitter> sitterslist = new ArrayList<>();
		for(BabySitterEntity each : sitterEntitiesList) {
			BabySitter sitter = new BabySitter();
			sitter.setBirthday(each.getDateOfBirth().toString());
			sitter.setCategory("sitter");
			sitter.setEmail(each.getLogin().getUser_id());
			sitter.setFirstName(each.getFirstName());
			sitter.setLastName(each.getLastName());
			sitter.setGender(each.getGender());
			sitter.setPassword(each.getLogin().getPass());
			sitterslist.add(sitter);
		}
		
		return sitterslist;
	}

	public ArrayList<BabySitter> getSitterInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean bookAppointment(String sitterID, String appointmentDate) throws ParseException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
	               .configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		AppointmentEntity appointment = new AppointmentEntity();
		Date appointmentDateFormatted = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(appointmentDate);
		appointment.setStartDate(appointmentDateFormatted);
		appointment.setEndDate(appointmentDateFormatted);
		
		Query<BabySitterEntity> query = session.createQuery("from BabySitterEntity b where b.sitterID =:sitterID");
		query.setParameter("sitterID", sitterID);
		BabySitterEntity babysitter = query.getSingleResult();
		appointment.setBabysitter(babysitter);
		return false;
	}
	
}
