package com.ooad.dao;

import java.util.ArrayList;

import com.ooad.beans.Appointment;
import com.ooad.beans.BabySitter;

public interface BabysitterDAO {
	public ArrayList<Appointment> getListOfAppointments(BabySitter user);
	public boolean saveAppointment(Appointment appointment);
}
