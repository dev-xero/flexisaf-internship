package github.dev.xero.pokemonrest.repositories;

import github.dev.xero.pokemonrest.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);
}
