package github.dev.xero.pokemonrest.controllers;

import github.dev.xero.pokemonrest.dto.HttpResponse;
import github.dev.xero.pokemonrest.dto.pokemon.CreatePokemonDto;
import github.dev.xero.pokemonrest.models.PokemonModel;
import github.dev.xero.pokemonrest.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Tag(name = "Pokemon Resource")
public class PokemonRestController {

    private final PokemonService pokemonService;

    // Constructor DI.
    public PokemonRestController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    @Operation(summary = "Default base endpoint.")
    public ResponseEntity<HttpResponse<String>> get() {
        return ResponseEntity.ok(
                HttpResponse.Ok("Pokemon API v1", "/", null)
        );
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new Pokemon")
    public ResponseEntity<HttpResponse<PokemonModel>> post(
            @Valid @RequestBody CreatePokemonDto dto,
            HttpServletRequest req
    ) {
        try {
            PokemonModel pokemon = pokemonService.create(dto);
            return ResponseEntity.ok(
                    HttpResponse.Ok(
                            "Pokemon created!",
                            req.getRequestURI(),
                            pokemon
                    )
            );
        } catch (BadRequestException ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                   HttpResponse.BadRequest(
                           ex.getMessage(),
                           "Cannot create duplicate Pokemon",
                           req.getRequestURI()
                   )
           );
        }
    }

}
