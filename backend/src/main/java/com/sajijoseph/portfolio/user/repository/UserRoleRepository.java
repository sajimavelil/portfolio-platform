package com.sajijoseph.portfolio.user.repository;

import com.sajijoseph.portfolio.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}