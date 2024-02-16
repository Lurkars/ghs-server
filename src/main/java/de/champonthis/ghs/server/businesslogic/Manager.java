/**
 * 
 */
package de.champonthis.ghs.server.businesslogic;

import java.util.List;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

import de.champonthis.ghs.server.entity.Game;
import de.champonthis.ghs.server.entity.GameCode;
import de.champonthis.ghs.server.entity.Setting;
import de.champonthis.ghs.server.model.GameModel;
import de.champonthis.ghs.server.model.Permissions;
import de.champonthis.ghs.server.model.Settings;
import de.champonthis.ghs.server.repository.GameCodeRepository;
import de.champonthis.ghs.server.repository.GameRepository;
import de.champonthis.ghs.server.repository.SettingRepository;

/**
 * The Class Manager.
 */
@Component
public class Manager implements SmartInitializingSingleton {

	@Autowired
	private Gson gson;

	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private GameCodeRepository gameCodeRepository;
	@Autowired
	private SettingRepository settingRepository;
	@Value("${ghs-server.gameCodesDump:true}")
	private boolean gameCodesDump;

	@Override
	public void afterSingletonsInstantiated() {
		if (gameCodesDump) {
			List<GameCode> gameCodes = gameCodes();
			if (gameCodes != null) {
				for (GameCode gameCode : gameCodes) {
					String code = gameCode.getGameCode();
					String jsonPath = gameCode.getJsonPath();
					if (jsonPath == null) {
						jsonPath = "[ALL]";
					}
					Long gameId = gameCode.getGameId();

					boolean game = gameRepository.existsById(gameId);
					boolean settings = settingRepository.existsById(gameId);

					if (!game) {
						System.err.println("NO GAME for GAMECODE '" + code + "' found!");
					} else {
						System.out.println(
								"\nGAMECODE '" + code + "' GRANTING '" + jsonPath + "' ON GAME '" + gameId
										+ (settings ? "' WITH SETTINGS" : "'") + "\n");
					}
				}
			}
		}
	}

	/**
	 * Game codes.
	 *
	 * @return the game code list
	 */
	public List<GameCode> gameCodes() {
		try {
			return gameCodeRepository.findAll();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Count game codes.
	 *
	 * @return the long
	 */
	public long countGameCodes() {
		return gameCodeRepository.count();
	}

	/**
	 * Creates the game code.
	 *
	 * @param code   the code
	 * @param gameId the game id
	 */
	public void createGameCode(String code, long gameId) {
		GameCode gameCode = new GameCode();
		gameCode.setGameCode(code);
		gameCode.setGameId(gameId);
		gameCodeRepository.save(gameCode);
	}

	/**
	 * Save game code.
	 *
	 * @param code        the code
	 * @param permissions the permissions
	 * @param gameId      the game id
	 */
	public void saveGameCode(String code, String permissions, long gameId) {
		GameCode gameCode = new GameCode();
		gameCode.setGameCode(code);
		gameCode.setJsonPath(permissions);
		gameCode.setGameId(gameId);
		gameCodeRepository.save(gameCode);
	}

	/**
	 * Gets the game id by game code.
	 *
	 * @param code the code
	 * @return the game id by game code
	 */
	public Long getGameIdByGameCode(String code) {
		GameCode gameCode = gameCodeRepository.findById(code).orElse(null);

		if (gameCode != null) {
			return gameCode.getGameId();
		}

		return null;
	}

	/**
	 * Gets the permissions by game code.
	 *
	 * @param code the code
	 * @return the permissions by game code
	 */
	public Permissions getPermissionsByGameCode(String code) {
		GameCode gameCode = gameCodeRepository.findById(code).orElse(null);

		if (gameCode != null && StringUtils.hasText(gameCode.getJsonPath())) {
			return gson.fromJson(gameCode.getJsonPath(), Permissions.class);
		}

		return null;
	}

	/**
	 * Gets the game.
	 *
	 * @param id the id
	 * @return the game
	 */
	public GameModel getGame(long id) {
		Game game = gameRepository.findById(id).orElse(null);

		if (game != null && StringUtils.hasText(game.getGame())) {
			return gson.fromJson(game.getGame(), GameModel.class);
		}

		return null;
	}

	/**
	 * Creates the game.
	 *
	 * @param game the game
	 * @return the integer
	 */
	public Long createGame(GameModel gameModel) {
		Game game = new Game();
		game.setGame(gson.toJson(gameModel));
		game = gameRepository.save(game);
		return game.getId();
	}

	/**
	 * Sets the game.
	 *
	 * @param id   the id
	 * @param game the game
	 */
	public void setGame(long id, GameModel gameModel) {
		Game game = gameRepository.findById(id).orElse(null);

		if (game != null) {
			game.setGame(gson.toJson(gameModel));
			gameRepository.save(game);
		}
	}

	/**
	 * Gets the settings.
	 *
	 * @param gameId the game id
	 * @return the settings
	 */
	public Settings getSettings(long gameId) {
		Setting setting = settingRepository.findById(gameId).orElse(null);

		if (setting != null && StringUtils.hasText(setting.getSettings())) {
			return gson.fromJson(setting.getSettings(), Settings.class);
		}

		return null;
	}

	/**
	 * Creates the settings.
	 *
	 * @param settings the settings
	 * @param gameId   the game id
	 */
	public void createSettings(Settings settings, long gameId) {
		Setting setting = new Setting();
		setting.setSettings(gson.toJson(settings));
		setting.setGameId(gameId);
		settingRepository.save(setting);
	}

	/**
	 * Sets the settings.
	 *
	 * @param settings the settings
	 * @param gameId   the game id
	 */
	public void setSettings(Settings settings, long gameId) {
		Setting setting = settingRepository.findById(gameId).orElse(null);

		if (settings != null) {
			setting.setSettings(gson.toJson(settings));
			settingRepository.save(setting);
		}
	}

}
