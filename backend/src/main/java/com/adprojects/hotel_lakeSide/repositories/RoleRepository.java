package com.adprojects.hotel_lakeSide.repositories;

import com.adprojects.hotel_lakeSide.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);


    boolean existsByName(String role);
}
