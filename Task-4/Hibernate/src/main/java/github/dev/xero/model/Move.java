package github.dev.xero.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Table Move {
 * move_id uuid [primary key]
 * board_id uuid [ref: - Board.board_id]
 * color Turn
 * move_number integer [default: 1]
 * move_notation varchar
 * fen_after varchar
 * time_left_ms integer
 * created_at timestamp
 * }
 */
@Entity
@Table(name = "moves")
@NoArgsConstructor
@Data
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "move_id")
    private UUID moveId;

    // FK
    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false, foreignKey = @ForeignKey(name = "board"))
    private Board board;

    @NotNull
    @Column(name = "color")
    private Color color;

    @NotNull
    @Column(name = "move_number")
    private Integer moveNumber;

    @NotNull
    @Column(name = "move_notation")
    private String moveNotation;

    @NotNull
    @Column(name = "fenAfter")
    private String fenAfter;

    @NotNull
    @Column(name = "time_lef_ms")
    private Integer timeLeftMs;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
