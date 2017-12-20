package com.ooad.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
@SessionAttributes({"parent","appointmentDate", "sitter","appointmentID","appointments"})
public class ParentController {
	@RequestMapping(value = { "/Listofbabysitters"}, method = RequestMethod.POST)
	public ModelAndView getBabySittersList(@ModelAttribute("parent") Parent parent, @RequestParam("appointmentDate") String appointmentDate, 
			@RequestParam("name") String name, @RequestParam("gender") String gender, @RequestParam("zipCode") String zipCode) {    
		ArrayList<BabySitter> sitters = null;
		try {
			sitters = parent.viewListofBabySitters(appointmentDate, name, gender);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ModelAndView map = new ModelAndView("parent_home");
	    map.addObject("sitters", sitters);
	    map.addObject("parent", parent);
	    map.addObject("appointmentDate", appointmentDate);
	    return map;
	}

	@RequestMapping(value = { "/getSitterInformation"}, method = RequestMethod.GET)
	public ModelAndView getSitterInformation(@ModelAttribute("parent") Parent parent,@ModelAttribute("appointmentDate") String appointmentDate, @RequestParam("sitterID") String sitterID) {
		System.out.println(parent.getFirstName());
		System.out.println(sitterID);
		BabySitter sitter = parent.getSitterInformation(sitterID);
	    ModelAndView map = new ModelAndView("babysitter_info");
	    map.addObject("sitter", sitter);
	    map.addObject("appointmentDate", appointmentDate);
	    return map;
	}
	
	@RequestMapping(value = { "/bookAppointment"}, method = RequestMethod.POST)
	public ModelAndView bookAppointment(@ModelAttribute("parent") Parent parent, @ModelAttribute("sitter") BabySitter sitter,
			@ModelAttribute("appointmentDate") String appointmentDate, @RequestParam("specialRequests") String specialRequests) {
		boolean success=false;
		try {
			parent.setSpecial_requests(specialRequests);
			success = parent.bookAppointment(sitter,appointmentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView map;
		if(success) {
			map = new ModelAndView("babysitter_info");
			
			map.addObject("successMessage","Request successful. Click on view orders to view your order");
		}
		else {
			map = new ModelAndView("babysitter_info");
			map.addObject("errorMessage","There's some error");
		}
	    return map;
	}
	
	@RequestMapping(value = { "/getAppointmentsList"}, method = RequestMethod.GET)
	public ModelAndView getAppointmentsList(@ModelAttribute("parent") Parent parent) {
		boolean success=false;
		ArrayList<Appointment> appointments = null;
		try {
			appointments = parent.getAppointmentsList();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(appointments != null && !appointments.isEmpty())
			success = true;
		ModelAndView map;
		if(success) {
			map = new ModelAndView("parent_notifi");
			map.addObject("appointments", appointments);
			map.addObject("parent", parent);
		}
		else {
			map = new ModelAndView("parent_notifi");
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
			map = new ModelAndView("parent_notifi");
			map.addObject("successMessage","Appointment successfully cancelled! Please log out and log back in to view changes!");
		}
		else {
			map = new ModelAndView("parent_notifi");
			map.addObject("errorMessage","Unable to cancel now. Please try again later.");
		}
	    return map;
	}
	
	@RequestMapping(value = { "/rateaSitter"}, method = RequestMethod.POST)
	public ModelAndView rateaSitter(@ModelAttribute("parent") Parent parent, @ModelAttribute("sitter") BabySitter sitter, @RequestParam("rating") Integer rating) {
		boolean success=false;
		success = parent.rateaSitter(sitter,rating);
		ModelAndView map;
		if(success) {
			map = new ModelAndView("babysitter_info");
			map.addObject("successMessage","Rated successfully!");
		}
		else {
			map = new ModelAndView("babysitter_info");
			map.addObject("parent",parent);
			map.addObject("errorMessage","Unable to rate now. Please try again later.");
		}
		return map;
	}
	
	
	@RequestMapping(value = { "/makePayment"}, method = RequestMethod.POST)
	public ModelAndView makePayment(@ModelAttribute("parent") Parent parent, @ModelAttribute("appointmentID") Integer appointmentID
			,@ModelAttribute("appointments") List<Appointment> appointments) {
		boolean success=false;
		success = parent.makePayment(appointmentID);
		ModelAndView modelandView;
		if(success) {
			modelandView = new ModelAndView("parent_notifi");
			modelandView.addObject("appointments", appointments);
			modelandView.addObject("parent");
			modelandView.addObject("successMessage","Payment successfully completed!");
		}
		else {
			modelandView = new ModelAndView("parent_notifi");
			modelandView.addObject("appointments", appointments);
			modelandView.addObject("parent");
			modelandView.addObject("errorMessage","Unable to pay now. Please try again later.");
		}
		return modelandView;
	}
	
	@RequestMapping(value = { "/checkout"}, method = RequestMethod.GET)
	public ModelAndView checkout(@ModelAttribute("parent") Parent parent, @RequestParam("appointmentID") Integer appointmentID) {
		ModelAndView map;
		map = new ModelAndView("payment");
		map.addObject("appointmentID", appointmentID);
		return map;
	}
}
