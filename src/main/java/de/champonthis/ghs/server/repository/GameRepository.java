package de.champonthis.ghs.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.champonthis.ghs.server.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
