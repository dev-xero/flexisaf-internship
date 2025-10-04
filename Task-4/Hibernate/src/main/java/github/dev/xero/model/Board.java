package github.dev.xero.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Table Board {
 * board_id uuid [primary key]
 * game_id uuid [ref: - Game.game_id]
 * fen varchar
 * whose_turn Turn [default: "w"]
 * created_at timestamp
 * updated_at timestamp
 * }
 */
@Entity
@Table(name = "boards")
@NoArgsConstructor
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "board_id")
    private UUID boardId;

    // FK
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false, foreignKey = @ForeignKey(name = "fk_game"))
    private Game game;

    @NotNull
    @Column(name = "fen")
    private String fen;

    @Enumerated(EnumType.STRING)
    @Column(name = "whose_turn")
    private Color whoseTurn;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}