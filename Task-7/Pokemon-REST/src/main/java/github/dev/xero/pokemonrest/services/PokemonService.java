package github.dev.xero.pokemonrest.services;

import github.dev.xero.pokemonrest.dto.HttpResponse;
import github.dev.xero.pokemonrest.dto.pokemon.CreatePokemonDto;
import github.dev.xero.pokemonrest.models.PokemonModel;
import github.dev.xero.pokemonrest.repositories.PokemonRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    // Constructor Dependency Injection.
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonModel create(CreatePokemonDto dto) throws BadRequestException {
        // Validation: make sure a pokemon with the same name doesn't already exist.
        if (pokemonRepository.findByName(dto.getName()) != null) {
            throw new BadRequestException("A pokemon with this name already exists!");
        }
        PokemonModel pokemon = new PokemonModel();
        pokemon.setName(dto.getName());
        pokemon.setType(dto.getType());
        pokemonRepository.save(pokemon);
        return pokemon;
    }
}
