/**
 * 
 */
package de.champonthis.ghs.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.champonthis.ghs.server.businesslogic.Manager;
import de.champonthis.ghs.server.model.GameModel;

/**
 * The Class GameController.
 */
@RestController
@RequestMapping("game")
public class GameController {

	@Autowired
	private Manager manager;

	@Value("${ghs-server.public:false}")
	private boolean isPublic;

	@Value("${ghs-server.debug:false}")
	private boolean debug;

	/**
	 * Gets the game.
	 *
	 * @param password the password
	 * @return the game
	 */
	@GetMapping
	public GameModel getGame(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String password) {

		if (!StringUtils.hasText(password)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		Integer gameId = manager.getGameIdByPassword(password);

		if (gameId == null) {
			// if first password or public create new game for password
			if (manager.countPasswords() == 0 || isPublic) {
				GameModel game = new GameModel();
				gameId = manager.createGame(game);
				manager.createPassword(password, gameId);
			} else {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN);
			}
		}

		GameModel game = manager.getGame(gameId);

		if (game == null) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}

		return game;
	}

}
