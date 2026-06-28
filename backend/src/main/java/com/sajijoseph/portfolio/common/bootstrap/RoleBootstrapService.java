package com.sajijoseph.portfolio.common.bootstrap;

import com.sajijoseph.portfolio.role.entity.Role;
import com.sajijoseph.portfolio.role.entity.RoleType;
import com.sajijoseph.portfolio.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleBootstrapService {

    private final RoleRepository roleRepository;

    public RoleBootstrapService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void initializeRoles() {

        createRole(RoleType.ROLE_SUPER_ADMIN);
        createRole(RoleType.ROLE_ADMIN);
        createRole(RoleType.ROLE_EDITOR);

    }

    private void createRole(RoleType roleType) {

        if (roleRepository.existsByName(roleType)) {
            return;
        }

        Role role = new Role();

        role.setName(roleType);
        role.setDescription(roleType.name());

        roleRepository.save(role);

        System.out.println("Created role : " + roleType);

    }

}