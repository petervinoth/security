package com.pop.Service;

import java.util.Optional;

import com.pop.Model.User;

public interface UserService {
	
	public User findByEmail(String email);
	// public Optional<User> findUserByResetToken(String resetToken);
	public void  saveUser(User user);

}
