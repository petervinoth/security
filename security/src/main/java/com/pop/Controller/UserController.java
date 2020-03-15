package com.pop.Controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pop.Model.User;
import com.pop.Service.UserService;
import com.pop.Service.UserServiceImpl;


@Controller
public class UserController {
	
	@Autowired
	 private UserService userService;
	
	BCryptPasswordEncoder Encoder=new BCryptPasswordEncoder(12);
	
	
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@RequestMapping(value= {"/","/login"}, method=RequestMethod.GET)
	 public ModelAndView login() {
	  ModelAndView model = new ModelAndView();
	  System.out.println("/login end point is working!!!!");
	   
	  model.setViewName("user/login");
	 // model.addObject("message", "please correct email & Password!!");
	  // model.addObject("user", new User());
	 
	  return model;
	 }
		
	
	
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	 public ModelAndView signup() {
	  ModelAndView model = new ModelAndView();
	  User user = new User();
	  model.addObject("user", user);
	  model.setViewName("user/signup");
	  
	  return model;
	 }
	 
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  User userExists = userService.findByEmail(user.getEmail());
	  
	  if(userExists != null) {
	   bindingResult.rejectValue("email", "error.user", "This email already exists!");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("user/signup");
	  } else {
	   userService.saveUser(user);
	   model.addObject("msg", "User has been registered successfully!");
	   model.addObject("user", new User());
	   model.setViewName("user/signup");
	  }
	  
	  return model;
	 }
		 
	 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("errors/access_denied");
	  return model;
	 }
	 
	 @RequestMapping(value={"/home/home"}, method=RequestMethod.GET)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  User user = userService.findByEmail(auth.getName());
	  
	  
	  model.setViewName("home/home");
	  return model;
	 }
	 @RequestMapping(value={"/add"}, method=RequestMethod.GET)
	 public ModelAndView add() {
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("/add");
		 System.out.print("welcome");
		 return mv;
	 }
	 @RequestMapping(value={"/forgotpassword"}, method=RequestMethod.GET)
	 public ModelAndView forgot() {
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("/forgotpassword");
		 System.out.print("welcome");
		 return mv;
	 }
	 @RequestMapping(value={"/Error"}, method=RequestMethod.GET)
	 public ModelAndView error() {
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("/Error");
		 //System.out.print("welcome");
		 return mv;
	 }
	 
	
}