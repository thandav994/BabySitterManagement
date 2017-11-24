package com.ooad.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.Appointment;
import com.ooad.beans.BabySitter;
import com.ooad.beans.Parent;

@Controller
@SessionAttributes({"parent","appointmentDate"})
public class ParentController {
	@RequestMapping(value = { "/Listofbabysitters"}, method = RequestMethod.GET)
	public ModelAndView getBabySittersList(@ModelAttribute("parent") Parent parent, @RequestParam("appointmentDate") String appointmentDate) {    
		ArrayList<BabySitter> sitters = null;
		try {
			sitters = parent.viewListofBabySitters(appointmentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ModelAndView map = new ModelAndView("Listofbabysitters");
	    map.addObject("sitters", sitters);
	    return map;
	}
	
	@RequestMapping(value = { "/getSitterInformation"}, method = RequestMethod.GET)
	public ModelAndView getSitterInformation(@RequestParam("sitterID") String sitterID) {
	    Parent parent = new Parent();
		BabySitter sitter = parent.getSitterInformation(sitterID);
	    ModelAndView map = new ModelAndView("sitterinfo");
	    map.addObject("sitter", sitter);

	    return map;
	}
	
	@RequestMapping(value = { "/bookAppointment"}, method = RequestMethod.GET)
	public ModelAndView bookAppointment(@ModelAttribute("parent") Parent parent, @ModelAttribute("appointmentDate") String appointmentDate, @RequestParam("sitterID") String sitterID) {
		boolean success=false;
		try {
			success = parent.bookAppointment(sitterID,appointmentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView map;
		if(success) {
			map = new ModelAndView("getSitterInformation");
			map.addObject("successMessage","Request successful");
		}
		else {
			map = new ModelAndView("getSitterInformation");
			map.addObject("errorMessage","There's some error");
		}
	    return map;
	}
	
	@RequestMapping(value = { "/getAppointmentsList"}, method = RequestMethod.GET)
	public ModelAndView getAppointmentsList(@ModelAttribute("parent") Parent parent) {
		boolean success=false;
		ArrayList<Appointment> appointments = parent.getAppointmentsList();
		if(!appointments.isEmpty())
			success = true;
		ModelAndView map;
		if(success) {
			map = new ModelAndView("viewAppointments");
			map.addObject("appointments", appointments);
		}
		else {
			map = new ModelAndView("viewAppointments");
			map.addObject("errorMessage","You do not have any appointments !! Go ahead and create one ! ");
		}
	    return map;
	}
	
	@RequestMapping(value = { "/cancelAppointment"}, method = RequestMethod.GET)
	public ModelAndView cancelAppointment(@ModelAttribute("parent") Parent parent, @RequestParam("appointmentID") Integer appointmentID) {
		boolean success=false;
		success = parent.cancelAppointment(appointmentID);
		ModelAndView map;
		if(success) {
			map = new ModelAndView("viewAppointments");
			map.addObject("SuccessMessage","Appointment successfully cancelled!");
		}
		else {
			map = new ModelAndView("Parentshome");
			map.addObject("errorMessage","Unable to cancel now. Please try again later.");
		}
	    return map;
	}

}
