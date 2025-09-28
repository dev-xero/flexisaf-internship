package io.github.dev.xero.springrestapi.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    boolean existsByUsername(String username);
    Optional<PlayerEntity> findByUsername(String username);
}
