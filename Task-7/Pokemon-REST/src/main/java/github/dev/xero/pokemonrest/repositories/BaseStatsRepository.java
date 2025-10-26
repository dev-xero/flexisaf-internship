package github.dev.xero.pokemonrest.repositories;

import github.dev.xero.pokemonrest.models.BaseStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseStatsRepository extends JpaRepository<BaseStats, Long> {
}
