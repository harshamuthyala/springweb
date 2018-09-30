package com.swacorp.springweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.swacorp.springweb.model.Users;
import com.swacorp.springweb.service.UserService;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView handle(ModelMap model) {
		logger.info("Going to HOME page");
		ModelAndView modelV = new ModelAndView();
		modelV.setViewName("home");
		model.addAttribute("message", "Spring");
		return modelV;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginHandle() {
		logger.info("Going to LOGIN page");
		ModelAndView modelV = new ModelAndView();
		modelV.setViewName("login");
		return modelV;
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public ModelAndView validateLoginHandle(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model) {
		logger.info("User trying to login to application: " + username);
		logger.info("Password that user '" + username + "' entered to login: " + password);

		ModelAndView modelV = new ModelAndView();

		List<Users> user = userService.validateUserLogin(username);

		if (user.size() > 0) {
			if (user.get(0).getPassword().equals(password)) {
				modelV.addObject("user", user.get(0).getFirstName());
				modelV.setViewName("welcome");
			} else {
				modelV.addObject("invalid", "Invalid Username or Password");
				modelV.setViewName("login");
			}
		}
		return modelV;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutHandle() {
		ModelAndView modelV = new ModelAndView();

		modelV.setViewName("home");
		return modelV;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupHandle() {
		logger.info("Going to SIGNUP page");
		ModelAndView modelV = new ModelAndView();
		modelV.setViewName("signup");
		return modelV;
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUserHandle(@ModelAttribute("user") @Valid Users user, BindingResult result, Model model) {
		
		logger.info("Saving the user to database: " + user.getUserName());

		ModelAndView modelV = new ModelAndView();

		if(result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			modelV.setViewName("signup");
			return modelV;
		}
		
		userService.save(user);
		model.addAttribute("user", user.getFirstName());
		modelV.setViewName("welcome");
		
		logger.info("User is now added to database: " + user.getUserName());

		return modelV;
		
	}

}
