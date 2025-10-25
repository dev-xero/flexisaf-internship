ALTER TABLE base_stats
    ADD defense INTEGER;

ALTER TABLE base_stats
    ADD speed INTEGER;

ALTER TABLE base_stats
    ALTER COLUMN defense SET NOT NULL;

ALTER TABLE base_stats
    ALTER COLUMN speed SET NOT NULL;