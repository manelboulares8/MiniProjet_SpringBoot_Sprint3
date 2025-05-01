package com.manell.etudiants.service;

import com.manell.etudiants.entities.Role;
import com.manell.etudiants.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
