package com.ooad.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.Login;
import com.ooad.beans.User;
import com.ooad.dao.LoginDAOImpl;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root() {
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}
	
	@RequestMapping(value= "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user) {
		// Creating login DAO object in order to persist the data in the database
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		try {
			loginDAO.addUser(user);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:login";
	}
	
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		// Creating login DAO object in order to persist the data in the database
		ModelAndView modelAndView = new ModelAndView("login");
		if(modelAndView.getModel().get("errorMessage") != null) {
			modelAndView.getModel().put("errorMessage", null);
		}
		return modelAndView;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login")Login login) {
		// Creating login DAO object in order to persist the data in the database
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		boolean isExistingUser = loginDAO.isExistingUser(login);
		ModelAndView modelAndView = null;
		if(isExistingUser)
			if(login.getCategory().contentEquals("parent"))
				modelAndView = new ModelAndView("Listofbabysitters");
			else if(login.getCategory().contentEquals("babysitter"))
				modelAndView = new ModelAndView("babysittershome");
		else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("errorMessage", "No profile found with the given credentials");
		}
		return modelAndView;
	}
	
	
	
}
