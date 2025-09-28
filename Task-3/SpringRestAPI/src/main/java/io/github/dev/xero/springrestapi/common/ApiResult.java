package io.github.dev.xero.springrestapi.common;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Standard API response wrapper")
public class ApiResult<T> {
    @Schema(description = "Success")
    private final boolean success;

    @Schema(description = "Message")
    private final String message;

    @Schema(description = "Payload")
    private final T data;

    @Schema(description = "Timestamp")
    private final LocalDateTime timestamp;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ApiResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResult<T> success(String message, T data) {
        return new ApiResult<>(true, message, data);
    }

    public static <T> ApiResult<T> error(String message) {
        return new ApiResult<>(false, message, null);
    }
}
