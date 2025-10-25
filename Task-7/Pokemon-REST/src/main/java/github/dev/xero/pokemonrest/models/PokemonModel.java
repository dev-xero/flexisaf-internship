package github.dev.xero.pokemonrest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "poke_id")
    private UUID pokeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PokemonType type;

    @Column(name = "generation", nullable = false)
    private Integer generation;

    // FK to base stats
    @OneToOne
    @JoinColumn(
            name = "base_stats_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_pokemon_base_stats")
    )
    private BaseStats baseStats;
}
