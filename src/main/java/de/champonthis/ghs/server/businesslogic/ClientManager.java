package de.champonthis.ghs.server.businesslogic;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component
public class ClientManager implements SmartInitializingSingleton {

	private final boolean lastestClientOnStartup;
	private final boolean ssl;
	private final int port;
	private final int httpPort;
	private final String externalHost;
	private final boolean defaultClientSettings;

	private final Gson gson = new Gson();

	public ClientManager(
			@Value("${ghs-server.lastestClientOnStartup:false}") boolean lastestClientOnStartup,
			@Value("${server.ssl.enabled:false}") boolean ssl,
			@Value("${server.port:8080}") int port,
			@Value("${server.http.port:8081}") int httpPort,
			@Value("${ghs-server.externalHost:}") String externalHost,
			@Value("${ghs-server.defaultClientSettings:false}") boolean defaultClientSettings) {
		this.lastestClientOnStartup = lastestClientOnStartup;
		this.ssl = ssl;
		this.port = port;
		this.httpPort = httpPort;
		this.externalHost = externalHost;
		this.defaultClientSettings = defaultClientSettings;
	}

	@Override
	public void afterSingletonsInstantiated() {
		if (lastestClientOnStartup) {
			installLatestClient();
		}
	}

	public boolean installLatestClient() {
		try {
			HttpURLConnection connection = (HttpURLConnection) URI.create(
					"https://api.github.com/repos/Lurkars/gloomhavensecretariat/releases/latest").toURL()
					.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			connection.disconnect();

			Pattern re = Pattern.compile(".*(https\\:\\/\\/(\\w+|\\.|\\/)+gloomhavensecretariat-v(\\w+|\\.)+\\.zip).*");
			String value = content.toString();
			Matcher matcher = re.matcher(value);

			if (matcher.matches()) {
				System.out.println("Download latest client from : " + matcher.group(1));
				connection = (HttpURLConnection) URI.create(matcher.group(1)).toURL().openConnection();
				connection.setRequestMethod("GET");
				ZipInputStream zipIn = new ZipInputStream(connection.getInputStream());
				ZipEntry entry = zipIn.getNextEntry();

				File outputPath = new File(System.getProperty("user.home"),
						".ghs" + File.separator + "gloomhavensecretariat");
				// clear old files
				if (outputPath.exists()) {
					if (outputPath.isDirectory()) {
						FileUtils.deleteDirectory(outputPath);
					} else {
						outputPath.delete();
					}
				}

				outputPath.mkdirs();

				// unzip
				while (entry != null) {
					String filePath = outputPath.getAbsolutePath() + File.separator + entry.getName();
					if (!entry.isDirectory()) {
						try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
							byte[] bytesIn = new byte[4096];
							int read = 0;
							while ((read = zipIn.read(bytesIn)) != -1) {
								bos.write(bytesIn, 0, read);
							}
						}
					} else {
						// if the entry is a directory, make the directory
						File dir = new File(filePath);
						dir.mkdirs();
					}
					zipIn.closeEntry();
					entry = zipIn.getNextEntry();
				}
				zipIn.close();

				if (!defaultClientSettings) {
					File defaultSettingsFile = new File(System.getProperty("user.home"),
							".ghs" + File.separator + "ghs-settings-default.json");

					if (defaultSettingsFile.exists() && defaultSettingsFile.isFile()) {
						Files.copy(defaultSettingsFile.toPath(),
								new File(outputPath.getAbsolutePath()
										+ File.separator + "ghs-settings-default.json")
										.toPath());
					}
				}

				System.out.println("Latest client installed!");
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void setupDefaultClientSettings() throws IOException {
		File clientDirectory = new File(System.getProperty("user.home"),
				".ghs" + File.separator + "gloomhavensecretariat");
		// check if client exists
		if (clientDirectory.exists()) {
			JsonObject defaultSettings = new JsonObject();
			String host = "localhost";
			List<String> hosts = getHosts();
			for (String tmpHost : hosts) {
				if (!tmpHost.equals(host)) {
					host = tmpHost;
					break;
				}
			}
			defaultSettings.addProperty("serverPort", port);
			defaultSettings.addProperty("serverUrl", host);
			defaultSettings.addProperty("serverWss", ssl);

			Writer defaultSettingsWrite = new FileWriter(
					clientDirectory.getAbsolutePath() + File.separator + "ghs-settings-default.json");
			gson.toJson(defaultSettings, defaultSettingsWrite);
			defaultSettingsWrite.close();
		}
	}

	public boolean checkClientRunning(String host) {
		try {
			HttpURLConnection connection = (HttpURLConnection) URI.create(getClientUrl(host)).toURL().openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int responseCode = connection.getResponseCode();
			connection.disconnect();
			return responseCode == 200;
		} catch (IOException e) {
			System.err.println("Connection failed to: " + getClientUrl(host));
		}

		return false;
	}

	public boolean checkClientRunningHttpOnly(String host) {
		try {
			HttpURLConnection connection = (HttpURLConnection) URI.create(getClientUrl(host, true)).toURL()
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int responseCode = connection.getResponseCode();
			connection.disconnect();
			return responseCode == 200;
		} catch (IOException e) {
			System.err.println("Connection failed to: " + getClientUrl(host, true));
			e.printStackTrace();
		}

		return false;
	}

	public String getClientUrl(String host) {
		return getClientUrl(host, false);
	}

	public String getClientUrl(String host, boolean httpOnly) {
		if (ssl && !httpOnly) {
			return "https://" + host + ":" + port + "/index.html";
		} else if (ssl && httpOnly) {
			return "http://" + host + ":" + httpPort + "/index.html";
		}

		return "http://" + host + ":" + port + "/index.html";
	}

	public List<String> getHosts() {
		LinkedList<String> hosts = new LinkedList<>();

		if (StringUtils.hasText(externalHost)) {
			hosts.push(externalHost);
		}

		hosts.push("localhost");
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(localhost, port));
			hosts.push(socket.getLocalAddress().getHostAddress());
			socket.close();

			socket = new Socket();
			socket.connect(new InetSocketAddress("champonthis.de", 443));
			hosts.push(socket.getLocalAddress().getHostAddress());
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return hosts;
	}

	@EventListener
	void checkOnStartup(ApplicationReadyEvent event) {
		for (String host : getHosts()) {
			if (checkClientRunning(host)) {
				System.out.println("Client running at: " + getClientUrl(host));
			}

			if (ssl && checkClientRunningHttpOnly(host)) {
				System.out.println("Client running at: " + getClientUrl(host, true));
			}
		}

		if (defaultClientSettings) {
			try {
				setupDefaultClientSettings();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
