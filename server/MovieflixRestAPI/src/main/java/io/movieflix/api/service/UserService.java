package io.movieflix.api.service;

import io.movieflix.api.entity.User;

public interface UserService {
	
	public User findOneUser(String email, String password);
	public User createUser(User user);
	//public String logout(HttpServletRequest request, HttpServletResponse response);
}
