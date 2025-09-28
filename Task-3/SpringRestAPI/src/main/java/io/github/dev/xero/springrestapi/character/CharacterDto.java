package io.github.dev.xero.springrestapi.character;

public record CharacterDto(
        Long playerId,
        String name,
        Integer healthPoints,
        Integer attackPower,
        Integer defensePower
) {}