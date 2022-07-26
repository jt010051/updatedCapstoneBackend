package com.capstone.service;




import com.capstone.domain.Role;
import com.capstone.domain.UserDetails;

import java.util.List;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
public interface UserService {
	UserDetails saveUser(UserDetails user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    UserDetails getUser(String username);
    List<UserDetails>getUsers();
}