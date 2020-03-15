package com.pop.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pop.Model.Role;
import com.pop.Model.User;
import com.pop.Repository.RoleRepository;
import com.pop.Repository.UserRepository;

@Component
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private RoleRepository roleRespository;
	 
	 @Autowired
	 private PasswordEncoder PasswordEncoder;
	 
	 @Override
	 public User findByEmail(String email) {
		 return userRepository.findByEmail(email);
	 }
	// @Override
		//public Optional<User> findUserByResetToken(String resetToken) {
			//return userRepository.findByResetToken(resetToken);
		//}
	 
	 @Override
	 public void saveUser(User user) {
		  user.setPassword(PasswordEncoder.encode(user.getPassword()));
		  user.setActive(1);
		  Role userRole = roleRespository.findByRole("ADMIN");
		  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  userRepository.save(user);
		 }
	//@Override
	//public Optional<User> findUserByResetToken(String resetToken) {
		// TODO Auto-generated method stub
		//return null;
	//}
	 }
	 



