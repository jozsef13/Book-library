package com.library.libraryClient.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.library.libraryClient.clients.UserClient;
import com.library.libraryService.modules.User;

@RestController
@RequestMapping(UserClientController.CONTRACT_BASE_URL)
public class UserClientController {

	@Autowired
	private UserClient uc;
	public static final String CONTRACT_BASE_URL = "/users";
	
	@PostMapping("/createUser")
	public ModelAndView createUser(User newUser)
	{
		ModelAndView model = new ModelAndView("home");
		User user = uc.createUser(newUser);
		model.addObject(user);
		return model;
	}
	
	@GetMapping("/ID/{userId}")
	public ModelAndView getUserById(@PathVariable int userId)
	{
		ModelAndView model = new ModelAndView("userInfo");
		User user = uc.getUserById(userId);
		model.addObject(user);
		return model;
	}
	
	@GetMapping("/login")
	public ModelAndView loginUser(HttpSession session, HttpServletRequest request)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ModelAndView model = new ModelAndView("userInfo");
		User user = uc.getUserByUsernameAndPassword(username, password);
		model.addObject(user);
		
		session.setAttribute("userId", user.getUserId());
		
		return model;
	}
	
	@GetMapping("/Username/{username}")
	public User getUserByUsername(@PathVariable String username)
	{
		return uc.getUserByUsername(username);
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(HttpSession session)
	{
		session.invalidate();
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	
	@RequestMapping(value = "/deleteUser/{userId}")
	public ModelAndView deleteUser(@PathVariable int userId)
	{
		ModelAndView model = new ModelAndView("accountDeleted");
		uc.deleteUser(userId);
		return model;
	}
}
