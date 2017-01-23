package io.movieflix.api.repository;

import io.movieflix.api.entity.User;

public interface UserRepository {
public User findOneUser(String email,String password);
public User createUser(User user);
public User findByEmail(String email);

}
