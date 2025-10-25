ALTER TABLE base_stats
    ADD defense INTEGER;

ALTER TABLE base_stats
    ADD speed INTEGER;

ALTER TABLE base_stats
    ALTER COLUMN defense SET NOT NULL;

ALTER TABLE pokemon
    ADD evolution_stage INTEGER;

ALTER TABLE pokemon
    ADD height DOUBLE PRECISION;

ALTER TABLE pokemon
    ADD weight DOUBLE PRECISION;

ALTER TABLE pokemon
    ALTER COLUMN evolution_stage SET NOT NULL;

ALTER TABLE pokemon
    ALTER COLUMN height SET NOT NULL;

ALTER TABLE base_stats
    ALTER COLUMN speed SET NOT NULL;

ALTER TABLE pokemon
    ALTER COLUMN weight SET NOT NULL;