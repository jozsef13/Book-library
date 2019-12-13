package com.library.libraryService.services;

import java.util.Collection;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.library.libraryService.modules.User;

@Service
public class UserService {

	private Hashtable<Integer, User> users = new Hashtable<Integer, User>();
	private Integer key = 1;
	
	public UserService() {
		User user = new User();
		
		user.setUserId(key);
		user.setUsername("jozsef13");
		user.setPassword("gabriel");
		user.setUserFirstName("Gabriel");
		user.setUserLastName("Simon");
		user.setUserPhoneNumber("0745666777");
		user.setUserEmailAddress("gabriel.simon980@gmail.com");
		users.put(key, user);
		key++;
		
		user = new User();
		user.setUserId(key);
		user.setUsername("comin7");
		user.setPassword("fotbal");
		user.setUserFirstName("Cosmin");
		user.setUserLastName("Popescu");
		user.setUserPhoneNumber("0754777666");
		user.setUserEmailAddress("cosmin.popescu07@gmail.com");
		users.put(key, user);
		key++;
	}

	public void createUser(User user) {
		user.setUserId(key);
		users.put(key, user);
		key++;
	}

	public User findByUsernameAndPassword(String username, String password) {
		
		Collection<User> userValues = users.values();
			
		for (User user : userValues) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return  users.get(user.getUserId());
			}
		}	
		
		return null;
	}

	public User findById(int userId) {
		if(users.containsKey(userId)){
			return users.get(userId);
		}
		
		return null;
	}

	public User findByUsername(String username) {
		Collection<User> userValues = users.values();
		
		for (User user : userValues) {
			if(user.getUsername().equals(username)){
				return users.get(user.getUserId());
			}
		}
		
		return null;
	}

	public void update(User otherUser, int userId) {

		users.replace(userId, otherUser);
		
	}

	public void delete(User user) {
		users.remove(user.getUserId());
	}
}
