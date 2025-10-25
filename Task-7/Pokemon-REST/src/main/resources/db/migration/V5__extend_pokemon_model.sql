CREATE SEQUENCE IF NOT EXISTS base_stats_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS pokemon_seq START WITH 1 INCREMENT BY 50;

ALTER TABLE base_stats
    DROP COLUMN base_stat_id CASCADE;

ALTER TABLE base_stats
    ADD base_stat_id BIGINT NOT NULL PRIMARY KEY;

ALTER TABLE pokemon
    DROP COLUMN base_stats_id;

ALTER TABLE pokemon
    DROP COLUMN poke_id;

ALTER TABLE pokemon
    ADD base_stats_id BIGINT NOT NULL;

ALTER TABLE pokemon
    ADD CONSTRAINT uc_pokemon_base_stats UNIQUE (base_stats_id);

ALTER TABLE pokemon
    ADD CONSTRAINT FK_POKEMON_BASE_STATS FOREIGN KEY (base_stats_id) REFERENCES base_stats (base_stat_id);

ALTER TABLE pokemon
    ADD poke_id BIGINT NOT NULL PRIMARY KEY;