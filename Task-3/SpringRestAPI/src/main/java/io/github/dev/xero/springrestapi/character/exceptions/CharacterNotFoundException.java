package io.github.dev.xero.springrestapi.character.exceptions;

public class CharacterNotFoundException extends RuntimeException {
   public CharacterNotFoundException(String message) {
       super(message);
   }
}
