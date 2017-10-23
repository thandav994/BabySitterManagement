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

import com.ooad.beans.BabySitter;
import com.ooad.beans.Parent;
import com.ooad.beans.User;

@Controller
@SessionAttributes({"user","appointmentDate"})
public class ParentController {
	@RequestMapping(value = { "/Listofbabysitters"}, method = RequestMethod.GET)
	public ModelAndView getBabySittersList(@ModelAttribute("user") User user, @RequestParam("appointmentDate") String appointmentDate) {
		Parent parent = new Parent();    
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
		ArrayList<BabySitter> sitters = parent.getSitterInformation(sitterID);
//		System.out.println("Kontroler EmployeeController");
//	    ArrayList<User> list = new ArrayList<>();
//	    User user1 = new User();
//	    user1.setFirstName("Thandav");
//	    user1.setLastName("K");
//	    list.add(user1);
//	    User user2 = new User();
//	    user2.setFirstName("Shreyash");
//	    user2.setLastName("M");
//	    list.add(user2);
	    ModelAndView map = new ModelAndView("Listofbabysitters");
	    map.addObject("sitters", sitters);

	    return map;
	}
	
	@RequestMapping(value = { "/bookAppointment"}, method = RequestMethod.GET)
	public ModelAndView bookAppointment(@ModelAttribute("user") User user, @ModelAttribute("appointmentDate") String appointmentDate, @RequestParam("sitterID") String sitterID) {
	    Parent parent = new Parent();
		boolean success=false;
		try {
			success = parent.bookAppointment(sitterID,appointmentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Kontroler EmployeeController");
//	    ArrayList<User> list = new ArrayList<>();
//	    User user1 = new User();
//	    user1.setFirstName("Thandav");
//	    user1.setLastName("K");
//	    list.add(user1);
//	    User user2 = new User();
//	    user2.setFirstName("Shreyash");
//	    user2.setLastName("M");
//	    list.add(user2);
		ModelAndView map;
		if(success) {
			map = new ModelAndView("Listofbabysitters");}
		else {
			map = new ModelAndView("getSitterInformation");
			map.addObject("errorMessage","There's some error");
		}
	    return map;
	}

}
