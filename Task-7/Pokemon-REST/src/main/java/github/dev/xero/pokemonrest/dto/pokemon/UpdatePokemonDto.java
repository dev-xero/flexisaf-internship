package github.dev.xero.pokemonrest.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdatePokemonDto {

    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 chars")
    private String name;

    @Min(value = 1, message = "Min allowed generation is 1")
    @Max(value = 10, message = "Max allowed generation is 10")
    public Integer generation;

    @Min(value = 1, message = "Min allowed evolution stage is 1")
    @Max(value = 64, message = "Max allowed evolution stage is 64")
    @JsonProperty("evolution_stage")
    public Integer evolutionStage;

    @DecimalMin(value = "0.1", message = "Min allowed weight is 0.1 kg")
    @DecimalMax(value = "120.0", message = "Max allowed weight is 120.0 kg")
    public Double weight;

    @DecimalMin(value = "0.1", message = "Min allowed height is 0.1 meters")
    @DecimalMax(value = "2.0", message = "Max allowed height is 2.0 meters")
    public Double height;

}
