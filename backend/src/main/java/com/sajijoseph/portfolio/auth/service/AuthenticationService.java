package com.sajijoseph.portfolio.auth.service;

import com.sajijoseph.portfolio.auth.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import com.sajijoseph.portfolio.auth.dto.request.LoginRequest;
import com.sajijoseph.portfolio.auth.dto.response.LoginResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(

                        new UsernamePasswordAuthenticationToken(

                                request.getEmail(),
                                request.getPassword()

                        )

                );

        String token =
                jwtService.generateAccessToken(request.getEmail());

        return new LoginResponse(

                token,

                "Bearer",

                3600

        );

    }

}