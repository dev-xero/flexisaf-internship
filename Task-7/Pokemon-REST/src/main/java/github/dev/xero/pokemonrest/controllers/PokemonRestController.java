package github.dev.xero.pokemonrest.controllers;

import github.dev.xero.pokemonrest.dto.HttpResponse;
import github.dev.xero.pokemonrest.dto.pokemon.CreatePokemonDto;
import github.dev.xero.pokemonrest.models.PokemonModel;
import github.dev.xero.pokemonrest.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    @Operation(
            summary = "Default base endpoint."
    )
    public ResponseEntity<HttpResponse<String>> get() {
        return pokemonService.base();
    }

    @PostMapping("/create")
    @Operation(
            summary = "Create a new Pokemon"
    )
    public ResponseEntity<HttpResponse<PokemonModel>> post(@Valid @RequestBody CreatePokemonDto dto) {
        return pokemonService.create(dto);
    }

}
