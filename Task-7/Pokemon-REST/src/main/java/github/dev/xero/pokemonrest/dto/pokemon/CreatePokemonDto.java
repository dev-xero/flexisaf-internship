package github.dev.xero.pokemonrest.dto.pokemon;

import github.dev.xero.pokemonrest.models.PokemonType;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreatePokemonDto {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 chars")
    public String name;

    @NotNull(message = "Type is required")
    public PokemonType type;

    @NotNull(message = "Generation is required")
    @Min(value = 1, message = "Min allowed generation is 1")
    @Max(value = 10, message = "Max allowed generation is 10")
    public Integer generation;

    @NotNull(message = "HP is required")
    @Min(value = 1, message = "Min allowed hp is 1")
    @Max(value = 100, message = "Max allowed hp is 100")
    public Integer hp;

    @NotNull(message = "Attack is required")
    @Min(value = 10, message = "Min allowed attack is 10")
    @Max(value = 300, message = "Max allowed attack is 300")
    public Integer attack;

    @NotNull(message = "Defense is required")
    @Min(value = 10, message = "Min allowed defense is 10")
    @Max(value = 300, message = "Max allowed defense is 300")
    public Integer defense;

    @NotNull(message = "Speed is required")
    @Min(value = 10, message = "Min allowed speed is 10")
    @Max(value = 300, message = "Max allowed speed is 300")
    public Integer speed;

}
