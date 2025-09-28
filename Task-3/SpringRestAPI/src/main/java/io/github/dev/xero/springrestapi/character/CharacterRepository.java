package io.github.dev.xero.springrestapi.character;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    List<CharacterEntity> findByPlayerId(Long playerId);
    boolean existsByPlayerIdAndName(Long playerId, String name);
}
