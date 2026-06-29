package com.sajijoseph.portfolio.auth.controller;

import com.sajijoseph.portfolio.auth.dto.request.LoginRequest;
import com.sajijoseph.portfolio.auth.dto.response.LoginResponse;
import com.sajijoseph.portfolio.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.sajijoseph.portfolio.common.response.ApiResponse;
import com.sajijoseph.portfolio.common.response.ApiResponseBuilder;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(
            AuthenticationService authenticationService) {

        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
            @Valid
            @RequestBody LoginRequest request) {

        return ApiResponseBuilder.success(
                "Login successful",
                authenticationService.login(request)
        );

    }

}