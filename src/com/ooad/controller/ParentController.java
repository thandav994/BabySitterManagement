package com.ooad.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.BabySitter;
import com.ooad.beans.Parent;

@Controller
@SessionAttributes("user")
public class ParentController {
	@RequestMapping(value = { "/Listofbabysitters"}, method = RequestMethod.GET)
	public ModelAndView getBabySittersList(@RequestParam("appointmentDate") String appointmentDate) {
	    Parent parent = new Parent();
		ArrayList<BabySitter> sitters = parent.viewListofBabySitters();
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

}
