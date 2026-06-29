package com.sajijoseph.portfolio.common.response;

import java.util.List;

public final class ApiResponseBuilder {

    private ApiResponseBuilder() {
    }

    public static <T> ApiResponse<T> success(
            String message,
            T data) {

        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse<Void> success(String message) {

        return ApiResponse.<Void>builder()
                .success(true)
                .message(message)
                .build();
    }

    public static ApiResponse<Void> failure(String message) {

        return ApiResponse.<Void>builder()
                .success(false)
                .message(message)
                .build();
    }

    public static ApiResponse<Void> validationFailure(
            String message,
            List<ApiValidationError> errors) {

        return ApiResponse.<Void>builder()
                .success(false)
                .message(message)
                .errors(errors)
                .build();
    }

}