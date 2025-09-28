package io.github.dev.xero.springrestapi.character.exceptions;

public class CharacterAlreadyExistsException extends RuntimeException {
    public CharacterAlreadyExistsException(String message) {
        super(message);
    }
}
