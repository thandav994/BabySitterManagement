package com.ooad.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.Login;
import com.ooad.beans.User;
import com.ooad.dao.LoginDAOImpl;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@RequestMapping(value= "/addUser", method = RequestMethod.POST)
	public String addUser(User user) {
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
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login")Login login) {
		ModelAndView modelAndView = null;
		User user = new User();
		user.setEmail(login.getUserID());
		user.setPassword(login.getPassword());
		user.setCategory(login.getCategory());
		if(user.login()) {
			if(login.getCategory().contentEquals("parent")) {
				modelAndView = new ModelAndView("Parentshome");
				modelAndView.addObject("user",user);
			}
			else if(login.getCategory().contentEquals("babysitter"))
				modelAndView = new ModelAndView("babysittershome");
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("errorMessage", "No profile found with the given credentials");
		}
		return modelAndView;
	}
	
}
