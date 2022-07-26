package com.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.domain.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
UserDetails findByusername(String username);
}
