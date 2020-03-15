package com.pop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pop.Model.Role;

@Repository("RoleRepository")
public interface RoleRepository  extends JpaRepository<Role,Integer>{
	
	Role findByRole(String role);

}



