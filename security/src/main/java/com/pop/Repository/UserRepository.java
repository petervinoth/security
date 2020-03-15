package com.pop.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pop.Model.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User,Long> {
	 User findByEmail(String email);
	//Optional<User> findByEmail(String email);
	// Optional<User> findByResetToken(String resetToken);

}





