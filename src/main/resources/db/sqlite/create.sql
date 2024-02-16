--liquibase formatted sql
--changeset lhaubaum:create-tables splitStatements:true endDelimiter:;
CREATE TABLE IF NOT EXISTS games (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    game STRING
);
CREATE TABLE IF NOT EXISTS passwords (
    password STRING PRIMARY KEY,
    game_id INTEGER,
    json_path STRING,
    FOREIGN KEY(game_id) REFERENCES games(id)
);
CREATE TABLE IF NOT EXISTS settings (
    game_id INTEGER PRIMARY KEY,
    settings STRING,
    FOREIGN KEY(game_id) REFERENCES games(id)
);
CREATE TABLE IF NOT EXISTS games_seq (next_val BIGINT);
INSERT INTO games_seq
SELECT (
        SELECT MAX(id) + 1
        from games
    )
WHERE NOT EXISTS (
        SELECT *
        FROM games_seq
    );