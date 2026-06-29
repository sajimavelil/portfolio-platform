package com.sajijoseph.portfolio.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;

    private String message;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    private T data;

    private List<ApiValidationError> errors;

}