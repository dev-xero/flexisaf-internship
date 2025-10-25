package github.dev.xero.pokemonrest.repositories;

import github.dev.xero.pokemonrest.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {
    Pokemon findByName(String name);
}
