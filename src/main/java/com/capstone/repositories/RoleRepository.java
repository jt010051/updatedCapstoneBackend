package com.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Role;
import com.capstone.domain.UserDetails;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);

}
