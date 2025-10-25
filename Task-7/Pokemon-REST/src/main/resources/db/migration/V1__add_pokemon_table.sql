CREATE TABLE pokemon
(
    poke_id UUID         NOT NULL,
    name    VARCHAR(255) NOT NULL,
    type    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_pokemon PRIMARY KEY (poke_id)
);