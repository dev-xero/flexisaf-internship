package github.dev.xero.pokemonrest.repositories;

import github.dev.xero.pokemonrest.models.PokemonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PokemonRepository extends JpaRepository<PokemonModel, UUID> {
    PokemonModel findByName(String name);
}
