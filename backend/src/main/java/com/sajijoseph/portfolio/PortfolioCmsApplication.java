package com.sajijoseph.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.sajijoseph.portfolio.auth.config.SecurityProperties;

@SpringBootApplication
@EnableConfigurationProperties(SecurityProperties.class)
public class PortfolioCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioCmsApplication.class, args);
    }

}
