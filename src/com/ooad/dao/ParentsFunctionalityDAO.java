package com.ooad.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.ooad.beans.BabySitter;
import com.ooad.beans.Parent;

public interface ParentsFunctionalityDAO {
	public ArrayList<BabySitter> getListofBabySitters(String appointmentDate) throws ParseException;
	public BabySitter getSitterInformation(String sitterID);
	public boolean bookAppointment(Parent parent, String sitterID, String appointmentDate);
	public boolean cancelAppointment(Integer appointmentID);
}
