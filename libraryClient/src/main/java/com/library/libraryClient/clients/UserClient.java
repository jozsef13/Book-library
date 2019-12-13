package com.library.libraryClient.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import com.library.libraryService.modules.User;

@Component
public class UserClient {

	@Autowired
	private RestOperations restOperations;
	private String url;
	
	@Autowired
	public UserClient(@Value("${service.url}") String url) {
		this.url = url;
	}
	
	public User createUser(User newUser)
	{
		final String uri = url + "users/createUser";
		return restOperations.postForObject(uri, newUser, User.class);
	}
	
	public User getUserById(int userId)
	{
		final String uri = url + "users/ID/" + userId;
		return restOperations.getForObject(uri, User.class);
	}
	
	public User getUserByUsernameAndPassword(String username, String password)
	{
		final String uri = url + "users/login/" + username + "&" + password;
		return restOperations.getForObject(uri, User.class);
	}
	
	public User getUserByUsername(String username)
	{
		final String uri = url + "users/Username/" + username;
		return restOperations.getForObject(uri, User.class);
	}

	public void deleteUser(int userId) {
		final String uri = url + "users/DeleteUser/" + userId;
		restOperations.delete(uri);
	}

	public void updateUser(int userId, User updatedUser) {
		final String uri = url + "users/UpdateUser/" + userId;
		restOperations.put(uri, updatedUser);
	}
}
