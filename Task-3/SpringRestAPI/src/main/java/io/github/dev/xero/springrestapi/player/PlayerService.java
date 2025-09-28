package io.github.dev.xero.springrestapi.player;

import io.github.dev.xero.springrestapi.player.exceptions.PlayerAlreadyExistsException;
import io.github.dev.xero.springrestapi.player.exceptions.PlayerNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public PlayerService(PlayerRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<PlayerEntity> findAll() {
        return repository.findAll();
    }

    public PlayerEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
    }

    public PlayerEntity register(PlayerDto dto) {
        if (repository.existsByUsername(dto.username())) {
            throw new PlayerAlreadyExistsException("Player already exists with username: " + dto.username());
        }

        String encodedPassword = passwordEncoder.encode(dto.password());

        PlayerEntity entity = new PlayerEntity();
        entity.setUsername(dto.username());
        entity.setPasswordHash(encodedPassword);

        return repository.save(entity);
    }
}
