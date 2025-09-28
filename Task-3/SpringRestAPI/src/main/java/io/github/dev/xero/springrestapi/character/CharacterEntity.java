package io.github.dev.xero.springrestapi.character;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;
    private String name;
    private Integer lvl;
    private Integer healthPoints;
    private Integer attackPower;
    private Integer defensePower;

    public CharacterEntity() {
    }

    public CharacterEntity(Long playerId, String name, Integer healthPoints, Integer attackPower, Integer defensePower) {
        this.playerId = playerId;
        this.name = name;
        this.lvl = 1;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public Long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLvl() {
        return this.lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public Integer getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getAttackPower() {
        return this.attackPower;
    }

    public void setAttackPower(Integer attackPower) {
        this.attackPower = attackPower;
    }

    public Integer getDefensePower() {
        return this.defensePower;
    }

    public void setDefensePower(Integer defensePower) {
        this.defensePower = defensePower;
    }
}

