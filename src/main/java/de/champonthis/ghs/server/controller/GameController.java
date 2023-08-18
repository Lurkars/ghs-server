/**
 * 
 */
package de.champonthis.ghs.server.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.socket.TextMessage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import de.champonthis.ghs.server.businesslogic.Manager;
import de.champonthis.ghs.server.model.GameCharacterModel;
import de.champonthis.ghs.server.model.GameModel;
import de.champonthis.ghs.server.model.GameMonsterModel;
import de.champonthis.ghs.server.model.Identifier;
import de.champonthis.ghs.server.model.Permissions;
import de.champonthis.ghs.server.socket.MessageHandler;
import de.champonthis.ghs.server.socket.model.WebSocketSessionContainer;

/**
 * The Class GameController.
 */
@RestController
@RequestMapping("game")
@CrossOrigin(origins = "*")
public class GameController {

	@Autowired
	private Manager manager;
	@Autowired
	private Gson gson;
	@Autowired
	private MessageHandler messageHandler;

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
	protected GameModel getGame(String password) {
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

	/**
	 * Request game.
	 *
	 * @param password the password
	 * @return the string
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public String requestGame(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String password) {
		return gson.toJson(getGame(password));
	}

	/**
	 * Update game.
	 *
	 * @param password the password
	 * @param payload  the payload
	 * @return the string
	 */
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public String updateGame(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String password,
			@RequestParam Optional<Boolean> silent, @RequestBody String payload) {

		GameModel game = getGame(password);

		Integer gameId = manager.getGameIdByPassword(password);

		Permissions permissions = manager.getPermissionsByPassword(password);

		if (payload == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid game payload");
		}

		try {
			GameModel gameUpdate = gson.fromJson(payload, GameModel.class);

			if (gameUpdate == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid game payload");
			}

			// Migration: check if revision is set
			if (gameUpdate.getRevision() != null && game.getRevision() != null) {
				if (gameUpdate.getRevision() == game.getRevision()) {
					game.setPlaySeconds(gameUpdate.getPlaySeconds());
					gameUpdate = game;
				} else if (gameUpdate.getRevision() <= game.getRevision()) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"invalid revision: " + gameUpdate.getRevision());
				}
			}

			if (permissions != null) {

				if (!permissions.isScenario()
						&& !gson.toJson(gameUpdate.getScenario()).equals(gson.toJson(game.getScenario()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: scenario");
				}
				if (!permissions.isScenario()
						&& !gson.toJson(gameUpdate.getSections()).equals(gson.toJson(game.getSections()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: scenario");
				}
				if (!permissions.isScenario()
						&& (gameUpdate.getEdition() != null && !gameUpdate.getEdition().equals(game.getEdition())
								|| game.getEdition() != null && !game.getEdition().equals(gameUpdate.getEdition()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: scenario");
				}
				if (!permissions.isElements()
						&& !gson.toJson(gameUpdate.getElementBoard()).equals(gson.toJson(game.getElementBoard()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: elements");
				}
				if (!permissions.isLootDeck()
						&& !gson.toJson(gameUpdate.getLootDeck()).equals(gson.toJson(game.getLootDeck()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: lootDeck");
				}
				if (!permissions.isRound() && gameUpdate.getRound() != game.getRound()) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: round");
				}
				if (!permissions.isRound() && !gameUpdate.getState().equals(game.getState())) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: round");
				}
				if (!permissions.isLevel() && gameUpdate.getLevel() != game.getLevel()) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: level");
				}
				if (!permissions.isAttackModifiers() && !gson.toJson(gameUpdate.getMonsterAttackModifierDeck())
						.equals(gson.toJson(game.getMonsterAttackModifierDeck()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: attackModifiers");
				}
				if (!permissions.isAttackModifiers() && !gson.toJson(gameUpdate.getAllyAttackModifierDeck())
						.equals(gson.toJson(game.getAllyAttackModifierDeck()))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing");
				}
				if (!permissions.isParty() && (!gson.toJson(gameUpdate.getParty()).equals(gson.toJson(game.getParty()))
						|| !gson.toJson(gameUpdate.getParties()).equals(gson.toJson(game.getParties())))) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: party");
				}
				if (!permissions.isCharacters()) {
					for (GameCharacterModel updateCharacter : gameUpdate.getCharacters()) {
						boolean characterPermission = false;
						boolean roundPermissions = permissions.isRound() && gameUpdate.getState() != game.getState();
						boolean lootDeckPermissions = permissions.isLootDeck()
								&& !gson.toJson(gameUpdate.getLootDeck()).equals(gson.toJson(game.getLootDeck()));
						boolean scenarioPermissions = permissions.isScenario()
								&& !gson.toJson(gameUpdate.getScenario()).equals(gson.toJson(game.getScenario()));

						for (GameCharacterModel character : game.getCharacters()) {
							if (updateCharacter.getName().equals(character.getName())
									&& updateCharacter.getEdition().equals(character.getEdition())) {
								for (Identifier characterFigure : permissions.getCharacter()) {
									if (characterFigure.getName().equals(character.getName())
											&& characterFigure.getEdition().equals(character.getEdition())) {
										characterPermission = true;
										break;
									}
								}
								if (characterPermission) {
									break;
								} else {
									updateCharacter.getAttackModifierDeck()
											.setActive(character.getAttackModifierDeck().isActive());

									if (permissions.isRound()) {
										character.setOff(updateCharacter.isOff());
										character.setActive(updateCharacter.isActive());
										character.setEntityConditions(updateCharacter.getEntityConditions());
									}

									if (roundPermissions || scenarioPermissions) {
										character.setOff(updateCharacter.isOff());
										character.setActive(updateCharacter.isActive());
										character.setInitiative(updateCharacter.getInitiative());
										character.setEntityConditions(updateCharacter.getEntityConditions());
										character.setAttackModifierDeck(updateCharacter.getAttackModifierDeck());
									}

									if (scenarioPermissions) {
										character.setHealth(updateCharacter.getHealth());
										character.setMaxHealth(updateCharacter.getMaxHealth());
										character.setLoot(updateCharacter.getLoot());
										character.setLootCards(updateCharacter.getLootCards());
										character.setTreasures(updateCharacter.getTreasures());
										character.setExperience(updateCharacter.getExperience());
										character.setEntityConditions(updateCharacter.getEntityConditions());
										character.setSummons(updateCharacter.getSummons());
										character.setExhausted(updateCharacter.isExhausted());
										character.setToken(updateCharacter.getToken());
									}

									if (lootDeckPermissions) {
										character.setLoot(updateCharacter.getLoot());
										character.setLootCards(updateCharacter.getLootCards());
									}
									String characterJson = gson.toJson(character);
									String updateCharacterJson = gson.toJson(updateCharacter);
									if (characterJson.equals(updateCharacterJson)) {
										characterPermission = true;
										break;
									}
								}
							}
						}
						if (!characterPermission) {
							throw new ResponseStatusException(HttpStatus.FORBIDDEN,
									"Permission(s) missing: characters");
						}
					}
				}
				if (!permissions.isMonsters()) {
					for (GameMonsterModel updateMonster : gameUpdate.getMonsters()) {
						boolean monsterPermission = false;
						boolean roundPermissions = permissions.isRound() && gameUpdate.getState() != game.getState();
						boolean scenarioPermissions = permissions.isScenario()
								&& !gson.toJson(gameUpdate.getScenario()).equals(gson.toJson(game.getScenario()));
						for (GameMonsterModel monster : game.getMonsters()) {
							if (updateMonster.getName().equals(monster.getName())
									&& updateMonster.getEdition().equals(monster.getEdition())) {
								for (Identifier monsterFigure : permissions.getMonster()) {
									if (monsterFigure.getName().equals(monster.getName())
											&& monsterFigure.getEdition().equals(monster.getEdition())) {
										monsterPermission = true;
										break;
									}
								}
								if (monsterPermission) {
									break;
								} else {

									if (permissions.isRound()) {
										monster.setOff(updateMonster.getOff());
										monster.setActive(updateMonster.getActive());
										monster.setEntities(updateMonster.getEntities());
									}

									if (roundPermissions) {
										monster.setAbility(updateMonster.getAbility());
										monster.setAbilities(updateMonster.getAbilities());
										monster.setEntities(updateMonster.getEntities());
										monster.setActive(updateMonster.getActive());
										monster.setOff(updateMonster.getOff());
									}

									if (scenarioPermissions
											|| gson.toJson(updateMonster).equals(gson.toJson(monster))) {
										monsterPermission = true;
										break;
									}
								}
							}
						}
						if (!monsterPermission && !game.getMonsters().isEmpty() && !scenarioPermissions) {
							throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Permission(s) missing: monsters");
						}
					}
				}
			}

			gameUpdate.setServer(false);
			manager.setGame(gameId, gameUpdate);

			if (!silent.isPresent() || !silent.get()) {
				for (WebSocketSessionContainer container : messageHandler.getWebSocketSessions()) {
					if (container.getGameId() == gameId
							&& messageHandler.getWebSocketSessionsCleanUp().indexOf(container) == -1) {
						JsonObject gameResponse = new JsonObject();
						if (!game.isServer()) {
							gameUpdate.setServer(messageHandler.isServerSession(container.getSession(), gameId));
						}
						gameResponse.addProperty("type", "game");
						gameResponse.add("payload", gson.toJsonTree(gameUpdate));
						container.getSession().sendMessage(new TextMessage(gson.toJson(gameResponse)));
					}
				}
			}

			return gson.toJson(gameUpdate);
		} catch (Exception e) {
			if (!(e instanceof ResponseStatusException)) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid game payload");
			} else {
				throw (ResponseStatusException) e;
			}
		}
	}

}
