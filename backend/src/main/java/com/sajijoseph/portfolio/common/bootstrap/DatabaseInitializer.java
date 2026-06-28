package com.sajijoseph.portfolio.common.bootstrap;

import com.sajijoseph.portfolio.role.entity.Role;
import com.sajijoseph.portfolio.role.entity.RoleType;
import com.sajijoseph.portfolio.role.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DatabaseInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        createRole(RoleType.ROLE_SUPER_ADMIN);
        createRole(RoleType.ROLE_ADMIN);
        createRole(RoleType.ROLE_EDITOR);

    }

    private void createRole(RoleType roleType) {

        if (!roleRepository.existsByName(roleType)) {

            Role role = new Role();

            role.setName(roleType);

            role.setDescription(roleType.name());

            roleRepository.save(role);

            System.out.println("Created role : " + roleType);

        }

    }

}