package github.dev.xero.pokemonrest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "base_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseStats {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID base_stat_id;

    @Column(name = "hp", nullable = false)
    private Integer hp;

    @Column(name = "attack", nullable = false)
    private Integer attack;

    @Column(name = "defense", nullable = false)
    private Integer defense;

    @Column(name = "speed", nullable = false)
    private Integer speed;

}
