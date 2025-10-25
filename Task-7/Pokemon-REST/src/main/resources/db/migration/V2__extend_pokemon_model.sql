CREATE TABLE base_stats
(
    base_stat_id UUID    NOT NULL,
    hp           INTEGER NOT NULL,
    attack       INTEGER NOT NULL,
    CONSTRAINT pk_base_stats PRIMARY KEY (base_stat_id)
);

ALTER TABLE pokemon
    ADD base_stats_id UUID;

ALTER TABLE pokemon
    ADD generation INTEGER;

ALTER TABLE pokemon
    ALTER COLUMN base_stats_id SET NOT NULL;

ALTER TABLE pokemon
    ALTER COLUMN generation SET NOT NULL;

ALTER TABLE pokemon
    ADD CONSTRAINT uc_pokemon_base_stats UNIQUE (base_stats_id);

ALTER TABLE pokemon
    ADD CONSTRAINT FK_POKEMON_BASE_STATS FOREIGN KEY (base_stats_id) REFERENCES base_stats (base_stat_id);