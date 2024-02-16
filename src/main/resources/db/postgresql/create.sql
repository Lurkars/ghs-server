--liquibase formatted sql
--changeset lhaubaum:create-tables splitStatements:true endDelimiter:;
CREATE TABLE IF NOT EXISTS games (id BIGSERIAL PRIMARY KEY, game TEXT);
CREATE TABLE IF NOT EXISTS game_codes (
    game_code VARCHAR(1024) PRIMARY KEY,
    game_id BIGINT,
    json_path TEXT,
    FOREIGN KEY(game_id) REFERENCES games(id)
);
CREATE TABLE IF NOT EXISTS settings (
    game_id BIGINT PRIMARY KEY,
    settings TEXT,
    FOREIGN KEY(game_id) REFERENCES games(id)
);