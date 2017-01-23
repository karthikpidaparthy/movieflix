package io.movieflix.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.api.entity.User;
import io.movieflix.api.service.UserService;

@RestController
@Scope("session")
public class UserController {
@Autowired
private UserService userService;



@RequestMapping(method=RequestMethod.GET, value="/login/{ema}/{pass}")
public User findOne(@PathVariable("ema") String email,@PathVariable("pass") String password)
{
	return userService.findOneUser(email,password);
}

@RequestMapping(method=RequestMethod.POST,value="signup")
public User create(@RequestBody User user)
{
	return userService.createUser(user);
}

@RequestMapping(value="/logout", method = RequestMethod.GET)
public void logoutPage (HttpServletRequest request, HttpServletResponse response) {
	request.getSession().invalidate();
}

}
