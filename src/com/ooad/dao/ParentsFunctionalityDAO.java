package com.ooad.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.ooad.beans.Appointment;
import com.ooad.beans.BabySitter;

public interface ParentsFunctionalityDAO {
	public ArrayList<BabySitter> getListofBabySitters(String appointmentDate) throws ParseException;
	public BabySitter getSitterInformation(String sitterID);
	public boolean bookAppointment(Appointment appointment);
	public boolean cancelAppointment(Integer appointmentID);
}
