package com.example.springsecurityjwt.dataAccess.abstracts;

import com.example.springsecurityjwt.entities.ERole;
import com.example.springsecurityjwt.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
