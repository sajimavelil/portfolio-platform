package com.sajijoseph.portfolio.common.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.sajijoseph.portfolio.auth.service.AdminBootstrapService;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final RoleBootstrapService roleBootstrapService;
    private final AdminBootstrapService adminBootstrapService;

    public DatabaseInitializer(
            RoleBootstrapService roleBootstrapService,
            AdminBootstrapService adminBootstrapService) {

        this.roleBootstrapService = roleBootstrapService;
        this.adminBootstrapService = adminBootstrapService;
    }

    @Override
    public void run(String... args) {

        roleBootstrapService.initializeRoles();

        adminBootstrapService.bootstrapAdmin();

        System.out.println("------------------------------------");
        System.out.println("Database bootstrap completed.");
        System.out.println("------------------------------------");

    }

}