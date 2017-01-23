package io.movieflix.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.api.entity.User;
import io.movieflix.api.exceptions.BadRequestException;
import io.movieflix.api.exceptions.EntityNotFoundException;
import io.movieflix.api.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepository;
	@Override
	@Transactional(readOnly=true)
	public User findOneUser(String email, String password) {
		// TODO Auto-generated method stub
	User user=userRepository.findOneUser(email,password);
	if(user==null)
	{
		throw new EntityNotFoundException("Enter correct credentials");
	}
	else
	{
		return userRepository.findOneUser(email,password);
	}
	}

	@Override
	@Transactional
	public User createUser(User user) {
		// TODO Auto-generated method stub
		System.err.println("inside user create");
		User user2=userRepository.findByEmail(user.getEmail());
		if(user2!=null)
				{
			throw new BadRequestException("User with this email id already exists");
				}
		else
		{
			System.err.println("inside else create");
			return userRepository.createUser(user);
		}
	}

	


}
