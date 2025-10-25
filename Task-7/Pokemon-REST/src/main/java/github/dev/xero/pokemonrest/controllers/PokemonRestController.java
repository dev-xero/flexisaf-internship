package github.dev.xero.pokemonrest.controllers;

import github.dev.xero.pokemonrest.dto.HttpResponse;
import github.dev.xero.pokemonrest.dto.pokemon.CreatePokemonDto;
import github.dev.xero.pokemonrest.models.Pokemon;
import github.dev.xero.pokemonrest.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Tag(name = "Pokemon Resource")
public class PokemonRestController {

    private final PokemonService pokemonService;

    // Constructor DI.
    public PokemonRestController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    @Operation(summary = "Default base endpoint")
    public ResponseEntity<HttpResponse<String>> get() {
        return ResponseEntity.ok(
                HttpResponse.Ok("Pokemon API v1", "/", null)
        );
    }

    @PostMapping("pokemon")
    @Operation(summary = "Create a new Pokemon")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Pokemon created successfully"),
    })
    public ResponseEntity<HttpResponse<Pokemon>> createPokemon(
            @Valid @RequestBody CreatePokemonDto dto,
            HttpServletRequest req
    ) {
        try {
            Pokemon pokemon = pokemonService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(
                            HttpResponse.Created(
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

    @GetMapping("pokemon")
    @Operation(summary = "Fetch all Pokemon")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fetched all Pokemon"),
    })
    public ResponseEntity<HttpResponse<List<Pokemon>>> getAllPokemon(
            HttpServletRequest req
    ) {
        List<Pokemon> pokemon = pokemonService.findAll();
        return ResponseEntity.ok(HttpResponse.Ok(
                "Fetched all Pokemon",
                req.getRequestURI(),
                pokemon
        ));
    }

    @GetMapping("pokemon/{id}")
    @Operation(summary = "Fetch a Pokemon by Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fetched a Pokemon by Id"),
    })
    public ResponseEntity<HttpResponse<Pokemon>> getPokemon(
            HttpServletRequest req,
            @PathVariable Long id
    ) {
        try {
            Pokemon pokemon = pokemonService.findById(id);
            return ResponseEntity.ok(HttpResponse.Ok(
                    "Fetched a Pokemon by Id",
                    req.getRequestURI(),
                    pokemon
            ));
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    HttpResponse.NotFound(
                            ex.getMessage(),
                            req.getRequestURI()
                    )
            );
        }
    }

}
