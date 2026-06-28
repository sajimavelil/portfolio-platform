package com.sajijoseph.portfolio.role.repository;

import com.sajijoseph.portfolio.role.entity.Role;
import com.sajijoseph.portfolio.role.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(RoleType name);

    boolean existsByName(RoleType name);

}