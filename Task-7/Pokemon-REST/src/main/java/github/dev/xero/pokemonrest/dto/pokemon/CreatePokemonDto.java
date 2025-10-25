package github.dev.xero.pokemonrest.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @NotNull(message = "Evolution stage is required")
    @Min(value = 1, message = "Min allowed evolution stage is 1")
    @Max(value = 64, message = "Max allowed evolution stage is 64")
    @JsonProperty("evolution_stage")
    public Integer evolutionStage;

    @NotNull(message = "Weight is required")
    @DecimalMin(value = "0.1", message = "Min allowed weight is 0.1 kg")
    @DecimalMax(value = "120.0", message = "Max allowed weight is 120.0 kg")
    public Double weight;

    @NotNull(message = "Height is required")
    @DecimalMin(value = "0.1", message = "Min allowed height is 0.1 meters")
    @DecimalMax(value = "2.0", message = "Max allowed height is 2.0 meters")
    public Double height;

}
