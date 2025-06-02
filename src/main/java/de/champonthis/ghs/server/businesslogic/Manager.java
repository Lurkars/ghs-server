package de.champonthis.ghs.server.businesslogic;

import java.util.List;

import org.springframework.beans.factory.SmartInitializingSingleton;
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

@Component
public class Manager implements SmartInitializingSingleton {

	private final Gson gson;
	private final GameRepository gameRepository;
	private final GameCodeRepository gameCodeRepository;
	private final SettingRepository settingRepository;
	private final boolean gameCodesDump;

	public Manager(
			@Value("${ghs-server.gameCodesDump:true}") boolean gameCodesDump,
			Gson gson,
			GameRepository gameRepository,
			GameCodeRepository gameCodeRepository,
			SettingRepository settingRepository) {
		this.gson = gson;
		this.gameRepository = gameRepository;
		this.gameCodeRepository = gameCodeRepository;
		this.settingRepository = settingRepository;
		this.gameCodesDump = gameCodesDump;
	}

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

	public List<GameCode> gameCodes() {
		try {
			return gameCodeRepository.findAll();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public long countGameCodes() {
		return gameCodeRepository.count();
	}

	public void createGameCode(String code, long gameId) {
		GameCode gameCode = new GameCode();
		gameCode.setGameCode(code);
		gameCode.setGameId(gameId);
		gameCodeRepository.save(gameCode);
	}

	public void saveGameCode(String code, String permissions, long gameId) {
		GameCode gameCode = new GameCode();
		gameCode.setGameCode(code);
		gameCode.setJsonPath(permissions);
		gameCode.setGameId(gameId);
		gameCodeRepository.save(gameCode);
	}

	public Long getGameIdByGameCode(String code) {
		GameCode gameCode = gameCodeRepository.findById(code).orElse(null);

		if (gameCode != null) {
			return gameCode.getGameId();
		}

		return null;
	}

	public Permissions getPermissionsByGameCode(String code) {
		GameCode gameCode = gameCodeRepository.findById(code).orElse(null);

		if (gameCode != null && StringUtils.hasText(gameCode.getJsonPath())) {
			return gson.fromJson(gameCode.getJsonPath(), Permissions.class);
		}

		return null;
	}

	public GameModel getGame(long id) {
		Game game = gameRepository.findById(id).orElse(null);

		if (game != null && StringUtils.hasText(game.getGame())) {
			return gson.fromJson(game.getGame(), GameModel.class);
		}

		return null;
	}

	public Long createGame(GameModel gameModel) {
		Game game = new Game();
		game.setGame(gson.toJson(gameModel));
		game = gameRepository.save(game);
		return game.getId();
	}

	public void setGame(long id, GameModel gameModel) {
		Game game = gameRepository.findById(id).orElse(null);

		if (game != null) {
			game.setGame(gson.toJson(gameModel));
			gameRepository.save(game);
		}
	}

	public Settings getSettings(long gameId) {
		Setting setting = settingRepository.findById(gameId).orElse(null);

		if (setting != null && StringUtils.hasText(setting.getSettings())) {
			return gson.fromJson(setting.getSettings(), Settings.class);
		}

		return null;
	}

	public void createSettings(Settings settings, long gameId) {
		Setting setting = new Setting();
		setting.setSettings(gson.toJson(settings));
		setting.setGameId(gameId);
		settingRepository.save(setting);
	}

	public void setSettings(Settings settings, long gameId) {
		Setting setting = settingRepository.findById(gameId).orElse(null);

		if (settings != null && setting != null) {
			setting.setSettings(gson.toJson(settings));
			settingRepository.save(setting);
		}
	}

}
