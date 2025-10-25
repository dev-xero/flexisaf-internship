package github.dev.xero.pokemonrest.dto.pokemon;

import github.dev.xero.pokemonrest.models.PokemonType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreatePokemonDto {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 chars.")
    public String name;

    @NotNull(message = "Type is required.")
    public PokemonType type;

}
