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

import com.ooad.beans.*;

@Controller
@SessionAttributes({"sitter","appointmentID"})
public class BabysitterController {
	
	@RequestMapping(value = { "/getBabySitterAppointmentsList"}, method = RequestMethod.GET)
	public ModelAndView getAppointmentsList(@ModelAttribute("sitter") BabySitter sitter) {
		boolean success=false;
		ArrayList<Appointment> appointments = null;
		try {
			appointments = sitter.getListOfAppointments();
			System.out.println(appointments.get(0).getId());
			System.out.println(appointments.get(0).getParent().getFirstName());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(appointments != null && !appointments.isEmpty())
			success = true;
		ModelAndView map;
		if(success) {
			map = new ModelAndView("babysitter_notifi");
			map.addObject("sitter",sitter);
			map.addObject("appointments", appointments);
		}
		else {
			map = new ModelAndView("babysitter_notifi");
			map.addObject("sitter",sitter);
			map.addObject("errorMessage","You do not have any appointments !! ");
		}
	    return map;
	}
	
	@RequestMapping(value = { "/getParentInformation"}, method = RequestMethod.GET)
	public ModelAndView getParentInformation(@ModelAttribute("sitter") BabySitter sitter, @RequestParam("parentID") String parentID, @RequestParam("appointmentID") int appointmentID) {
		System.out.println(parentID);
		Parent parent = sitter.getParentInformation(parentID);
	    ModelAndView map = new ModelAndView("parent_info");
	    if(parent != null) {
	    	map.addObject("parent", parent);
	    	map.addObject("appointmentID", appointmentID);
	    }
	    else {
	    	map.addObject("errorMessage", "Unable to fetch information. Please try again.");
	    }
	    return map;
	}
	
	@RequestMapping(value = { "/updateanAppointment"}, method = RequestMethod.GET)
	public ModelAndView updateanAppointment(@ModelAttribute("sitter") BabySitter sitter,@ModelAttribute("appointmentID") int appointmentID, @RequestParam("decision") boolean decision) {
		Appointment app = new Appointment();
		app.setId(appointmentID);
		boolean success = sitter.updateBabySitterApproval(app, decision);
		ModelAndView map;
		if(success) {
			map = new ModelAndView("parent_info");
			map.addObject("successMessage", "Successfully updated request. Click on home and view appointments to check the updated status");
		} else {
			map = new ModelAndView("parent_info");
			map.addObject("errorMessage", "Unable to accept request. Please try again later.");
		}
		
		return map;
		
	}
}
