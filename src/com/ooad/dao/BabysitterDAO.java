package com.ooad.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.ooad.beans.Appointment;
import com.ooad.beans.Parent;
import com.ooad.beans.BabySitter;

public interface BabysitterDAO {
	public ArrayList<Appointment> getListOfAppointments(BabySitter user);
	public void saveAppointment(Appointment appointment);
	public Parent getParentInfo(int parentID);
}
