package com.library.libraryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.libraryService.modules.User;
import com.library.libraryService.services.UserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(UserController.CONTRACT_BASE_URL)
@ApiModel(description = "Operations about user")
public class UserController {

	@Autowired
	private UserService userService;
	public static final String CONTRACT_BASE_URL = "/users";

	@PostMapping("/createUser")
	@ApiOperation(value = "Create an user and add him to database", response = User.class)
	private User createUser(@ApiParam(value = "User object to be created and added") @RequestBody User user) {
		userService.createUser(user);
		return user;
	}

	@GetMapping("/login/{username}&{password}")
	@ApiOperation(value = "Login using username and password", response = User.class)
	private User loginUser(@ApiParam(value = "The user name for login") @PathVariable String username, @ApiParam(value = "The password for login") @PathVariable String password) {
		User user = userService.findByUsernameAndPassword(username, password);
		return user;
	}

	@GetMapping("/ID/{userId}")
	@ApiOperation(value = "Find an user by its ID", response = User.class)
	private User getUserById(@ApiParam(value = "ID of the user to be returned") @PathVariable int userId) {
		return userService.findById(userId);
	}

	@GetMapping("/Username/{username}")
	@ApiOperation(value = "Find an user by its username", response = User.class)
	private User getUserByUsername(@ApiParam(value = "Username of the user to be returned") @PathVariable String username) {
		return userService.findByUsername(username);
	}

	@PutMapping("/UpdateUser/{userId}")
	@ApiOperation(value = "Update an user", response = User.class)
	private User updateUser(@ApiParam(value = "Updated user object") @RequestBody User user, @ApiParam(value = "ID of the user that need to be updated") @PathVariable int userId) {
		userService.update(user, userId);
		return user;

	}

	@DeleteMapping("/DeleteUser/{userId}")
	@ApiOperation(value = "Delete an user", response = User.class)
	private String deleteUser(@ApiParam(value = "ID of the user to be deleted") @PathVariable int userId) {
		User user = userService.findById(userId);
		userService.delete(user);
		return "Deleted successfully!";
	}
}
