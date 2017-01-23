package io.movieflix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.movieflix.api.entity.User;
@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findOneUser(String email, String password) {
		TypedQuery<User> typedQuery=em.createNamedQuery("User.findByEmailPassword", User.class);
		typedQuery.setParameter("cEmail", email);
		typedQuery.setParameter("cPass", password);
	List<User> userList=typedQuery.getResultList();
	if(userList!=null && userList.size()==1)
	{
		return userList.get(0);
	}
	else
	{
		return null;
	}
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		System.err.println("inside user persist");
		em.persist(user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		System.err.println("inside find by email");
	TypedQuery<User> typedQuery=em.createNamedQuery("User.findByEmail", User.class);
		typedQuery.setParameter("cEmail", email);
		
	List<User> userList=typedQuery.getResultList();
	if(userList!=null && userList.size()==1)
	{
		return userList.get(0);
	}
	else
	{
		return null;
	}
	}



}
