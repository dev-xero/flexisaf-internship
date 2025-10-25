package github.dev.xero.pokemonrest.repositories;

import github.dev.xero.pokemonrest.models.BaseStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BaseStatsRepository extends JpaRepository<BaseStats, UUID> {
}
