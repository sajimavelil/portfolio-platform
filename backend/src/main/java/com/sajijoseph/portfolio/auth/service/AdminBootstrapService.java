package com.sajijoseph.portfolio.auth.service;

import com.sajijoseph.portfolio.auth.config.BootstrapAdminProperties;
import com.sajijoseph.portfolio.role.entity.Role;
import com.sajijoseph.portfolio.role.entity.RoleType;
import com.sajijoseph.portfolio.role.repository.RoleRepository;
import com.sajijoseph.portfolio.user.entity.User;
import com.sajijoseph.portfolio.user.entity.UserRole;
import com.sajijoseph.portfolio.user.repository.UserRepository;
import com.sajijoseph.portfolio.user.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminBootstrapService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordManager passwordManager;
    private final BootstrapAdminProperties adminProperties;

    public AdminBootstrapService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            UserRoleRepository userRoleRepository,
            PasswordManager passwordManager,
            BootstrapAdminProperties adminProperties) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordManager = passwordManager;
        this.adminProperties = adminProperties;
    }

    public void bootstrapAdmin() {

        if (userRepository.existsByEmailIgnoreCase(adminProperties.getEmail())) {
            System.out.println("Bootstrap administrator already exists.");
            return;
        }

        User user = new User();

        user.setFirstName(adminProperties.getFirstName());
        user.setLastName(adminProperties.getLastName());
        user.setEmail(adminProperties.getEmail());

        user.setPassword(
                passwordManager.encode(adminProperties.getPassword())
        );

        user.setEmailVerified(true);

        user = userRepository.save(user);

        Role superAdminRole = roleRepository.findByName(RoleType.ROLE_SUPER_ADMIN)
                .orElseThrow(() -> new RuntimeException("ROLE_SUPER_ADMIN not found"));

        UserRole userRole = new UserRole();

        userRole.setUser(user);
        userRole.setRole(superAdminRole);

        userRoleRepository.save(userRole);

        System.out.println("Bootstrap administrator created successfully.");
    }
}