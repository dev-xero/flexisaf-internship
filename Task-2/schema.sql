CREATE TYPE "Winner" AS ENUM (
  'w',
  'b',
  'draw',
  'null'
);

CREATE TYPE "TimeControl" AS ENUM (
  '10',
  '5',
  '3'
);

CREATE TYPE "GameResult" AS ENUM (
  'checkmate',
  'timeout',
  'resignation',
  'draw',
  'null'
);

CREATE TYPE "Turn" AS ENUM (
  'w',
  'b'
);

CREATE TABLE "Player" (
  "player_id" uuid PRIMARY KEY,
  "username" varchar,
  "email" varchar UNIQUE,
  "password_hash" varchar,
  "is_verified" boolean,
  "created_at" timestamp,
  "rating" integer DEFAULT 1200
);

CREATE TABLE "Game" (
  "game_id" uuid PRIMARY KEY,
  "white_player_id" uuid,
  "black_player_id" uuid,
  "duration" integer,
  "is_ongoing" boolean DEFAULT true,
  "winner" "Winner" DEFAULT null,
  "time_control" "TimeControl" DEFAULT '10',
  "game_result" "GameResult" DEFAULT null,
  "created_at" timestamp,
  "finished_at" timestamp
);

CREATE TABLE "Board" (
  "board_id" uuid PRIMARY KEY,
  "game_id" uuid,
  "fen" varchar,
  "whose_turn" "Turn" DEFAULT 'w',
  "created_at" timestamp,
  "updated_at" timestamp
);

CREATE TABLE "Move" (
  "move_id" uuid PRIMARY KEY,
  "board_id" uuid,
  "color" "Turn",
  "move_number" integer DEFAULT 1,
  "move_notation" varchar,
  "fen_after" varchar,
  "time_left_ms" integer,
  "created_at" timestamp
);

ALTER TABLE "Game" ADD FOREIGN KEY ("white_player_id") REFERENCES "Player" ("player_id");

ALTER TABLE "Game" ADD FOREIGN KEY ("black_player_id") REFERENCES "Player" ("player_id");

ALTER TABLE "Board" ADD FOREIGN KEY ("game_id") REFERENCES "Game" ("game_id");

ALTER TABLE "Move" ADD FOREIGN KEY ("board_id") REFERENCES "Board" ("board_id");
