package com.ooad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ooad.beans.BabySitter;
import com.ooad.beans.Parent;

@Controller
@SessionAttributes({"parent","sitter"})
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView root() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
    }
	
	@RequestMapping(value = "/babysitter_registration", method = RequestMethod.GET)
	public ModelAndView babysitterRegister() {
		ModelAndView modelAndView = new ModelAndView("babysitter_registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/parent_registration", method = RequestMethod.GET)
	public ModelAndView parentRegister() {
		ModelAndView modelAndView = new ModelAndView("parent_registration");
		return modelAndView;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		// Creating login DAO object in order to persist the data in the database
		ModelAndView modelAndView = new ModelAndView("login");
		if(modelAndView.getModel().get("errorMessage") != null)
			modelAndView.getModel().put("errorMessage", null);
		return modelAndView;
	}
	
	@RequestMapping(value= "/parent_home", method = RequestMethod.GET)
	public ModelAndView parentHome(@ModelAttribute("parent") Parent parent) {
		// Creating login DAO object in order to persist the data in the database
		ModelAndView modelAndView = new ModelAndView("parent_home");
		modelAndView.addObject("parent",parent);
		if(modelAndView.getModel().get("errorMessage") != null)
			modelAndView.getModel().put("errorMessage", null);
		return modelAndView;
	}
	
	@RequestMapping(value= "/sitter_home", method = RequestMethod.GET)
	public ModelAndView sitterHome(@ModelAttribute("sitter") BabySitter sitter) {
		// Creating login DAO object in order to persist the data in the database
		ModelAndView modelAndView = new ModelAndView("babysitter_home");
		modelAndView.addObject("sitter",sitter);
		System.out.println(sitter);
		if(modelAndView.getModel().get("errorMessage") != null)
			modelAndView.getModel().put("errorMessage", null);
		return modelAndView;
	}
}
