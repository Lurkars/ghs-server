/**
 * 
 */
package de.champonthis.ghs.server.businesslogic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

import de.champonthis.ghs.server.model.GameModel;
import de.champonthis.ghs.server.model.Permissions;
import de.champonthis.ghs.server.model.Settings;

/**
 * The Class Manager.
 */
@Component
public class Manager {

	@Autowired
	private Gson gson;

	private Connection connection = null;

	/**
	 * Instantiates a new manager.
	 */
	public Manager() {
		try {
			File ghsFolder = new File(System.getProperty("user.home"), ".ghs");
			if (!ghsFolder.exists()) {
				ghsFolder.mkdirs();
			} else if (ghsFolder.isFile()) {
				System.err.println("ghs folder is file!");
			}

			File dbFile = new File(System.getProperty("user.home"), ".ghs" + File.separator + "ghs.sqlite");

			// migration
			migrateToUserDir(dbFile);

			connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile.getAbsolutePath());
			Statement statement = connection.createStatement();
			statement.executeUpdate("PRAGMA foreign_keys = ON");
			statement.executeUpdate(
					"CREATE TABLE IF NOT EXISTS games (id INTEGER PRIMARY KEY AUTOINCREMENT, game STRING)");
			statement.executeUpdate(
					"CREATE TABLE IF NOT EXISTS passwords (password STRING PRIMARY KEY, game_id INTEGER, json_path STRING, FOREIGN KEY(game_id) REFERENCES games(id))");
			statement.executeUpdate(
					"CREATE TABLE IF NOT EXISTS settings (game_id INTEGER PRIMARY KEY, settings STRING, FOREIGN KEY(game_id) REFERENCES games(id))");

			ResultSet passwordResultSet = passwords();

			if (passwordResultSet != null) {
				while (passwordResultSet.next()) {
					String password = passwordResultSet.getString("password");
					String jsonPath = passwordResultSet.getString("json_path");
					if (jsonPath == null) {
						jsonPath = "[ALL]";
					}
					int gameId = passwordResultSet.getInt("game_id");
					System.out.println(
							"\nPASSWORD: " + password + " GRANTING " + jsonPath + " ON GAME: " + gameId + "\n");
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Migrate to user dir.
	 *
	 * @param dbFile the db file
	 */
	private void migrateToUserDir(File dbFile) {
		File oldDbFile = new File("ghs.sqlite");
		if (oldDbFile.exists()) {
			try {
				Files.move(oldDbFile.toPath(), dbFile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File clientFolder = new File("gloomhavensecretary");

		if (clientFolder.exists() && clientFolder.isDirectory()) {
			try {
				Files.move(clientFolder.toPath(),
						new File(System.getProperty("user.home"), ".ghs" + File.separator + "gloomhavensecretary")
								.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Passwords.
	 *
	 * @return the result set
	 */
	public ResultSet passwords() {
		try {
			return connection.createStatement().executeQuery("SELECT game_id,password,json_path FROM passwords");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Count passwords.
	 *
	 * @return the int
	 */
	public int countPasswords() {
		try {
			Statement statement = connection.createStatement();
			ResultSet passwordCountResultSet = statement.executeQuery("SELECT count(*) FROM passwords;");

			if (passwordCountResultSet.next()) {
				return passwordCountResultSet.getInt("count(*)");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return 0;
	}

	/**
	 * Creates the password.
	 *
	 * @param password the password
	 * @param gameId   the game id
	 */
	public void createPassword(String password, int gameId) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO passwords (game_id, password) VALUES(" + gameId + ",'" + password + "')");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Save password.
	 *
	 * @param password    the password
	 * @param permissions the permissions
	 * @param gameId      the game id
	 */
	public void savePassword(String password, String permissions, int gameId) {
		try {
			Statement statement = connection.createStatement();
			if (getGameIdByPassword(password) == null) {
				statement.executeUpdate("INSERT INTO passwords (game_id,json_path,password) VALUES(" + gameId + ",'"
						+ permissions + "','" + password + "')");
			} else {
				statement.executeUpdate(
						"UPDATE passwords SET json_path = '" + permissions + "' where password = '" + password + "'");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Gets the game id by password.
	 *
	 * @param password the password
	 * @return the game id by password
	 */
	public Integer getGameIdByPassword(String password) {
		try {
			Statement statement = connection.createStatement();
			ResultSet gameIdResultSet = statement
					.executeQuery("SELECT game_id FROM passwords WHERE password = '" + password + "';");
			if (gameIdResultSet.next()) {
				return gameIdResultSet.getInt("game_id");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Gets the permissions by password.
	 *
	 * @param password the password
	 * @return the permissions by password
	 */
	public Permissions getPermissionsByPassword(String password) {
		try {
			Statement statement = connection.createStatement();
			ResultSet gameIdResultSet = statement
					.executeQuery("SELECT json_path FROM passwords WHERE password = '" + password + "';");
			if (gameIdResultSet.next()) {
				String json_path = gameIdResultSet.getString("json_path");
				if (StringUtils.hasText(json_path)) {

					return gson.fromJson(json_path, Permissions.class);
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Gets the game.
	 *
	 * @param id the id
	 * @return the game
	 */
	public GameModel getGame(int id) {
		try {
			Statement statement = connection.createStatement();
			ResultSet gameResultSet = statement.executeQuery("SELECT game FROM games WHERE id = " + id + ";");

			if (gameResultSet.next()) {
				return gson.fromJson(gameResultSet.getString("game"), GameModel.class);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Creates the game.
	 *
	 * @param game the game
	 * @return the integer
	 */
	public Integer createGame(GameModel game) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO games (game) VALUES('" + gson.toJson(game) + "')");
			ResultSet resultSet = statement.getGeneratedKeys();
			return resultSet.getInt(1);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Sets the game.
	 *
	 * @param id   the id
	 * @param game the game
	 */
	public void setGame(int id, GameModel game) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE games SET game= '" + gson.toJson(game) + "' WHERE id=" + id);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Gets the settings.
	 *
	 * @param gameId the game id
	 * @return the settings
	 */
	public Settings getSettings(int gameId) {
		try {
			Statement statement = connection.createStatement();
			ResultSet settingsResultSet = statement
					.executeQuery("SELECT settings FROM settings WHERE game_id = " + gameId + ";");

			if (settingsResultSet.next()) {
				return gson.fromJson(settingsResultSet.getString("settings"), Settings.class);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Creates the settings.
	 *
	 * @param settings the settings
	 * @param gameId   the game id
	 */
	public void createSettings(Settings settings, int gameId) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO settings (game_id, settings) VALUES(" + gameId + ",'" + gson.toJson(settings) + "')");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Sets the settings.
	 *
	 * @param settings the settings
	 * @param gameId   the game id
	 */
	public void setSettings(Settings settings, int gameId) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE settings SET settings= '" + gson.toJson(settings) + "' WHERE game_id=" + gameId);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
