package de.champonthis.ghs.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "settings")
@Data
public class Setting {

    @Id
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "settings")
    private String settings;

}
