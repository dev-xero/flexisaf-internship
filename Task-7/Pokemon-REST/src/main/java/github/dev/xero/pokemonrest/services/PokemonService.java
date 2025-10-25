package github.dev.xero.pokemonrest.services;

import github.dev.xero.pokemonrest.dto.pokemon.CreatePokemonDto;
import github.dev.xero.pokemonrest.models.BaseStats;
import github.dev.xero.pokemonrest.models.Pokemon;
import github.dev.xero.pokemonrest.repositories.BaseStatsRepository;
import github.dev.xero.pokemonrest.repositories.PokemonRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final BaseStatsRepository baseStatsRepository;

    // Constructor Dependency Injection.
    public PokemonService(PokemonRepository pokemonRepository, BaseStatsRepository baseStatsRepository) {
        this.pokemonRepository = pokemonRepository;
        this.baseStatsRepository = baseStatsRepository;
    }

    public Pokemon create(CreatePokemonDto dto) throws BadRequestException {
        // Validation: make sure a pokemon with the same name doesn't already exist.
        if (pokemonRepository.findByName(dto.getName()) != null) {
            throw new BadRequestException("A pokemon with this name already exists!");
        }

        Pokemon pokemon = new Pokemon();
        pokemon.setName(dto.getName());
        pokemon.setType(dto.getType());
        pokemon.setGeneration(dto.getGeneration());
        pokemon.setEvolutionStage(dto.getEvolutionStage());
        pokemon.setWeight(dto.getWeight());
        pokemon.setHeight(dto.getHeight());

        BaseStats baseStats = new BaseStats();
        baseStats.setHp(dto.getHp());
        baseStats.setAttack(dto.getAttack());
        baseStats.setDefense(dto.getDefense());
        baseStats.setSpeed(dto.getSpeed());

        pokemon.setBaseStats(baseStats);

        baseStatsRepository.save(baseStats);
        pokemonRepository.save(pokemon);

        return pokemon;
    }

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }
}
