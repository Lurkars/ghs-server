package de.champonthis.ghs.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "game_codes")
@Data
public class GameCode {

    @Id
    @Column(name = "game_code")
    private String gameCode;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "json_path")
    private String jsonPath;

}
