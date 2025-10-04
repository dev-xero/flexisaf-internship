package github.dev.xero.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Table Game {
 * game_id uuid [primary key]
 * white_player_id uuid [ref: - Player.player_id]
 * black_player_id uuid [ref: - Player.player_id]
 * duration integer
 * is_ongoing boolean [default: true]
 * winner Winner [default: null]
 * time_control TimeControl [default: "10"]
 * game_result GameResult [default: null]
 * created_at timestamp
 * finished_at timestamp
 * }
 */
@Entity
@Table(name = "games")
@NoArgsConstructor
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "game_id")
    private UUID gameId;

    // FK
    @ManyToOne
    @JoinColumn(name = "white_player_id", nullable = false, foreignKey = @ForeignKey(name = "fk_white_player"))
    private Player whitePlayer;

    // FK
    @ManyToOne
    @JoinColumn(name = "black_player_id", nullable = false, foreignKey = @ForeignKey(name = "fk_black_player"))
    private Player blackPlayer;

    @NotNull
    @Column(name = "duration")
    private Integer duration;

    @NotNull
    @Column(name = "time_control")
    private Integer TimeControl;

    @NotNull
    @Column(name = "is_ongoing")
    private Boolean isOngoing;

    @NotNull
    @Column(name = "game_result")
    @Enumerated(EnumType.STRING)
    private GameResult gameResult;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "finished_at")
    private LocalDateTime finishedAt;
}
