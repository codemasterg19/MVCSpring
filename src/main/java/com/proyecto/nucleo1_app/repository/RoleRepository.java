package com.proyecto.nucleo1_app.repository;

import com.proyecto.nucleo1_app.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
