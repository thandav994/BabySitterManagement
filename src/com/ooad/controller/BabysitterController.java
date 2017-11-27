package com.ooad.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.*;

@Controller
@SessionAttributes({"sitter"})
public class BabysitterController {
	
	@RequestMapping(value = { "/getBabySitterAppointmentsList"}, method = RequestMethod.GET)
	public ModelAndView getAppointmentsList(@ModelAttribute("sitter") BabySitter sitter) {
		boolean success=false;
		ArrayList<Appointment> appointments = null;
		try {
			appointments = sitter.getListOfAppointments();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(appointments != null && !appointments.isEmpty())
			success = true;
		ModelAndView map;
		if(success) {
			map = new ModelAndView("babysitter_notifi");
			map.addObject("appointments", appointments);
		}
		else {
			map = new ModelAndView("babysitter_notifi");
			map.addObject("errorMessage","You do not have any appointments !! ");
		}
	    return map;
	}
	
	@RequestMapping(value = { "/updateanAppointment"}, method = RequestMethod.GET)
	public ModelAndView updateanAppointment(@ModelAttribute("sitter") BabySitter sitter, boolean decision, Integer appointmentID) {
		Appointment app = new Appointment();
		app.setId(appointmentID);
		sitter.updateBabySitterApproval(app, decision);
		return null;
		
	}
	/* Approve or Reject an appointment */
	//loggedinUser.updateBabySitterApproval(appointment,true/false);
	
}
