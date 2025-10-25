package github.dev.xero.pokemonrest.dto;

import lombok.Data;

import java.time.LocalDateTime;

// Generic Http Response Model
@Data
public class HttpResponse<T> {
    private final String message;
    private final String error;
    private final String path;
    private final Integer status;
    private final T data;
    private final LocalDateTime timestamp;

    public HttpResponse(String message, String error, String path, Integer status, T data) {
        this.message = message;
        this.error = error;
        this.path = path;
        this.status = status;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> HttpResponse<T> Ok(String message, String path, T data) {
        return new HttpResponse<>(
                message,
                null,
                path,
                200,
                data
        );
    }

    public static <T> HttpResponse<T> BadRequest(String message, String error, String path) {
        return new HttpResponse<>(
                message,
                error,
                path,
                400,
                null
        );
    }
}
