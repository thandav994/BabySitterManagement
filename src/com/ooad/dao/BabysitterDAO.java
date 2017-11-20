package com.ooad.dao;

import java.text.ParseException;

import com.ooad.beans.Appointment;
import com.ooad.beans.Parent;
import com.ooad.beans.User;

public interface BabysitterDAO {
	public Appointment[] getListOfAppointments(User user);
	public void saveAppointment(Appointment appointment);
	public Parent getParentInfo(int parentID);
}
