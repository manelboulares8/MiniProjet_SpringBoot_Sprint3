package com.manell.etudiants.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.manell.etudiants.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}