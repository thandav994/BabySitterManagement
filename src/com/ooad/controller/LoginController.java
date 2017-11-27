package com.ooad.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.BabySitter;
import com.ooad.beans.Login;
import com.ooad.beans.Parent;
import com.ooad.dao.LoginDAOImpl;

@Controller
@SessionAttributes({"parent", "sitter"})
public class LoginController {
	
	@RequestMapping(value= "/addParent", method = RequestMethod.POST)
	public String addParent(Parent parent) {
		// Creating login DAO object in order to persist the data in the database
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		try {
			loginDAO.addParent(parent);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:login";
	}
	
	@RequestMapping(value= "/addSitter", method = RequestMethod.POST)
	public String addSitter(BabySitter sitter) {
		// Creating login DAO object in order to persist the data in the database
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		try {
			loginDAO.addBabySitter(sitter);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login")Login login) {
		ModelAndView modelAndView = null;
			if(login.getCategory().contentEquals("parent")) {
				Parent parent = new Parent();
				parent.setEmail(login.getUserID());
				parent.setPassword(login.getPassword());
				if(parent.login()) {
					modelAndView = new ModelAndView("parent_home");
					modelAndView.addObject("parent",parent);
				}
			}
			else if(login.getCategory().contentEquals("babysitter")) {
				BabySitter sitter = new BabySitter();
				sitter.setEmail(login.getUserID());
				sitter.setPassword(login.getPassword());
				if(sitter.login()) {
					modelAndView = new ModelAndView("babysitter_home");
					modelAndView.addObject("sitter",sitter);
				}
			}
				
		if(modelAndView == null) {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("errorMessage", "No profile found with the given credentials");
		}
		return modelAndView;
	}
}
