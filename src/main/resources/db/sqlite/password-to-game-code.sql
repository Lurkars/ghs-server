--liquibase formatted sql
--changeset lhaubaum:create-tables splitStatements:true endDelimiter:;
CREATE TABLE IF NOT EXISTS game_codes (
    game_code STRING PRIMARY KEY,
    game_id INTEGER,
    json_path STRING,
    FOREIGN KEY(game_id) REFERENCES games(id)
);
INSERT INTO game_codes(game_code, game_id, json_path)
SELECT password,
    game_id,
    json_path
FROM passwords;
DROP TABLE passwords;