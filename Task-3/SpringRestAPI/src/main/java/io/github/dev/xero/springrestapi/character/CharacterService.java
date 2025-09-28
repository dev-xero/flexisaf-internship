package io.github.dev.xero.springrestapi.character;

import io.github.dev.xero.springrestapi.character.exceptions.CharacterAlreadyExistsException;
import io.github.dev.xero.springrestapi.character.exceptions.CharacterNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<CharacterEntity> findAll() {
        return repository.findAll();
    }

    public CharacterEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character not found with id: " + id));
    }

    public List<CharacterEntity> findByPlayerId(Long playerId) {
        return repository.findByPlayerId(playerId);
    }

    public CharacterEntity create(CharacterDto dto) {
        if (repository.existsByPlayerIdAndName(dto.playerId(), dto.name())) {
            throw new CharacterAlreadyExistsException("Character already exists with name: " + dto.name() + " for player: " + dto.playerId());
        }

        CharacterEntity entity = new CharacterEntity();
        entity.setPlayerId(dto.playerId());
        entity.setName(dto.name());
        entity.setLvl(1);
        entity.setHealthPoints(dto.healthPoints());
        entity.setAttackPower(dto.attackPower());
        entity.setDefensePower(dto.defensePower());

        return repository.save(entity);
    }
}
