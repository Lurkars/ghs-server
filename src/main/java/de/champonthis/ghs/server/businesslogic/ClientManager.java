/**
 * 
 */
package de.champonthis.ghs.server.businesslogic;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
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

/**
 * The Class ClientManager.
 */
@Component
public class ClientManager implements SmartInitializingSingleton {

	@Value("${ghs-server.lastestClientOnStartup:false}")
	private boolean lastestClientOnStartup;
	@Value("${server.ssl.enabled:false}")
	private boolean ssl;
	@Value("${server.port:8080}")
	private int port;
	@Value("${server.http.port:8081}")
	private int httpPort;
	@Value("${ghs-server.externalHost:}")
	private String externalHost;

	@Override
	public void afterSingletonsInstantiated() {
		if (lastestClientOnStartup) {
			installLatestClient();
		}
	}

	/**
	 * Install latest client.
	 *
	 * @return true, if successful
	 */
	public boolean installLatestClient() {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(
					"https://api.github.com/repos/Lurkars/gloomhavensecretariat/releases/latest").openConnection();
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
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
				connection = (HttpURLConnection) new URL(matcher.group(1)).openConnection();
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
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
						byte[] bytesIn = new byte[4096];
						int read = 0;
						while ((read = zipIn.read(bytesIn)) != -1) {
							bos.write(bytesIn, 0, read);
						}
						bos.close();
					} else {
						// if the entry is a directory, make the directory
						File dir = new File(filePath);
						dir.mkdirs();
					}
					zipIn.closeEntry();
					entry = zipIn.getNextEntry();
				}
				zipIn.close();

				File defaultSettingsFile = new File(System.getProperty("user.home"),
						".ghs" + File.separator + "ghs-settings-default.json");

				if (defaultSettingsFile.exists() && defaultSettingsFile.isFile()) {
					Files.copy(defaultSettingsFile.toPath(),
							new File(System.getProperty("user.home"), ".ghs" + File.separator + "gloomhavensecretariat"
									+ File.separator + "ghs-settings-default.json").toPath());
				}

				System.out.println("Latest client installed!");
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Check client running.
	 *
	 * @param host the host
	 * @return true, if successful
	 */
	public boolean checkClientRunning(String host) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(getClientUrl(host)).openConnection();
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

	/**
	 * Check client running http only.
	 *
	 * @param host the host
	 * @return true, if successful
	 */
	public boolean checkClientRunningHttpOnly(String host) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(getClientUrl(host, true)).openConnection();
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

	/**
	 * Gets the client url.
	 *
	 * @param host the host
	 * @return the client url
	 */
	public String getClientUrl(String host) {
		return getClientUrl(host, false);
	}

	/**
	 * Gets the client url.
	 *
	 * @param host     the host
	 * @param httpOnly the http only
	 * @return the client url
	 */
	public String getClientUrl(String host, boolean httpOnly) {
		if (ssl && !httpOnly) {
			return "https://" + host + ":" + port + "/index.html";
		} else if (ssl && httpOnly) {
			return "http://" + host + ":" + httpPort + "/index.html";
		}

		return "http://" + host + ":" + port + "/index.html";
	}

	/**
	 * Gets the hosts.
	 *
	 * @return the hosts
	 */
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

	/**
	 * Check on startup.
	 *
	 * @param event the event
	 */
	@EventListener
	void checkOnStartup(ApplicationReadyEvent event) {
		for (String host : getHosts()) {
			if (checkClientRunning(host)) {
				System.out.println("Client running at: " + getClientUrl(host));
			}
		}
	}
}
