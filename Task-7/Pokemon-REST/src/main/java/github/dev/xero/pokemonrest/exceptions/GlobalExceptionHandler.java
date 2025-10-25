package github.dev.xero.pokemonrest.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import github.dev.xero.pokemonrest.dto.HttpResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Global Validation Exception Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse<Void>> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest req
    ) {
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        HttpResponse<Void> body = HttpResponse.BadRequest(
                "Validation failed",
                errors,
                req.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Invalid JSON data exception handler.
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HttpResponse<Void>> handleInvalidEnumValue(
            HttpMessageNotReadableException ex,
            HttpServletRequest request
    ) {
        String message = "Invalid request body";
        String error = ex.getCause() instanceof InvalidFormatException cause
                ? "Invalid value for field '" + cause.getPath().get(0).getFieldName() + "'."
                + " Expected one of: " + Arrays.toString(cause.getTargetType().getEnumConstants())
                : ex.getMessage();

        HttpResponse<Void> body = HttpResponse.BadRequest(
                message,
                error,
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(body);
    }
}
