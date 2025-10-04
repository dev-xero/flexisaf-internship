package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "player_id", unique = true)
    private UUID playerId;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "password_hash")
    private String passwordHash;

    @NotNull
    @Column(name = "is_verified")
    private Boolean isVerified;

    @NotNull
    @Column(name = "rating")
    private Integer rating;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Player(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isVerified = false;
        this.rating = 1200;
        this.createdAt = LocalDateTime.now();
    }
}
