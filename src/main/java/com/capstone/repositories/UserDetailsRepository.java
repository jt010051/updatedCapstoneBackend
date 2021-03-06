package com.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.domain.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	
}
