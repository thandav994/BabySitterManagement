package com.ooad.dao;

import java.text.ParseException;

import com.ooad.beans.Appointment;
import com.ooad.beans.User;

public interface BabySitterDAO {
	public Appointment[] GetListOfAppointments(User user) throws ParseException;
	public void UpdateBabySitterApproval(Appointment appointment, Boolean approval) throws ParseException;
}
