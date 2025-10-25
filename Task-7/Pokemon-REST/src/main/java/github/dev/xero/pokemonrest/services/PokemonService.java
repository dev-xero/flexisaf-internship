package github.dev.xero.pokemonrest.services;

import github.dev.xero.pokemonrest.dto.HttpResponse;
import github.dev.xero.pokemonrest.dto.pokemon.CreatePokemonDto;
import github.dev.xero.pokemonrest.models.PokemonModel;
import github.dev.xero.pokemonrest.repositories.PokemonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    // Constructor Dependency Injection.
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public ResponseEntity<HttpResponse<String>> base() {
        return ResponseEntity.ok(
                HttpResponse.Ok("Pokemon API v1", "/", null)
        );
    }

    public ResponseEntity<HttpResponse<PokemonModel>> create(CreatePokemonDto dto) {
        // Validation: make sure a pokemon with the same name doesn't already exist.
        if (pokemonRepository.findByName(dto.getName()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(HttpResponse.BadRequest(
                            "A Pokemon with this name already exists!",
                            "Cannot create duplicate Pokemon",
                            "/create"
                    )
            );
        }
        PokemonModel pokemon = new PokemonModel();
        pokemon.setName(dto.getName());
        pokemon.setType(dto.getType());
        pokemonRepository.save(pokemon);
        return ResponseEntity.ok(
                HttpResponse.Ok(
                        "Pokemon created!",
                        "/create",
                        pokemon
                )
        );
    }
}
