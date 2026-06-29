package com.sajijoseph.portfolio.common.dto;

import lombok.Builder;
import lombok.Getter;
import com.sajijoseph.portfolio.common.response.ApiValidationError;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ErrorResponse {

    private boolean success;

    private String message;

    private LocalDateTime timestamp;

    private List<ApiValidationError> errors;

}