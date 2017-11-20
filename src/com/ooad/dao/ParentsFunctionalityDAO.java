package com.ooad.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.ooad.beans.BabySitter;

public interface ParentsFunctionalityDAO {
	public ArrayList<BabySitter> getListofBabySitters(String appointmentDate) throws ParseException;
	public BabySitter getSitterInformation();
	public boolean bookAppointment(String sitterID, String appointmentDate) throws ParseException;
}
