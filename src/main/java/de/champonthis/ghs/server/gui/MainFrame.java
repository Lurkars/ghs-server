package de.champonthis.ghs.server.gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import de.champonthis.ghs.server.businesslogic.ClientManager;
import de.champonthis.ghs.server.businesslogic.Manager;
import de.champonthis.ghs.server.entity.GameCode;

@Component
@Conditional(GuiCondition.class)
public class MainFrame extends JFrame implements SmartInitializingSingleton {

	private static final long serialVersionUID = 1L;

	@Autowired
	private Manager manager;
	@Autowired
	private ClientManager clientManager;
	@Value("${server.port:8080}")
	private int port;
	@Value("${server.http.port:8081}")
	private int httpPort;
	@Value("${server.ssl.enabled:false}")
	private boolean ssl;
	private String clientUrl = null;

	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JLabel ipLabel = new JLabel();
	private JLabel portLabel = new JLabel();
	private JButton quitButton = new JButton("Quit");
	private JButton installButton = new JButton("Install latest Client");
	private JButton openClientButton = new JButton("Open Client");
	private JScrollPane tablePane = null;

	public MainFrame() {
		initUI();
	}

	private void initUI() {
		topPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new BorderLayout());

		ipLabel.setText("IP");
		topPanel.add(ipLabel, BorderLayout.WEST);

		portLabel.setText("Port");
		topPanel.add(portLabel, BorderLayout.EAST);

		this.add(topPanel, BorderLayout.PAGE_START);

		installButton.addActionListener((ActionEvent event) -> {
			SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					clientManager.installLatestClient();
					return null;
				}

				@Override
				protected void done() {
					installButton.setEnabled(true);
					checkClient();
				}
			};

			openClientButton.setVisible(false);
			installButton.setEnabled(false);
			swingWorker.execute();

		});

		bottomPanel.add(installButton, BorderLayout.WEST);

		openClientButton.addActionListener((ActionEvent event) -> {
			if (StringUtils.hasText(clientUrl)) {
				try {
					Desktop.getDesktop().browse(new URI(clientUrl));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		bottomPanel.add(openClientButton, BorderLayout.CENTER);

		openClientButton.setVisible(false);

		quitButton.addActionListener((ActionEvent event) -> System.exit(0));

		bottomPanel.add(BorderLayout.EAST, quitButton);

		this.add(bottomPanel, BorderLayout.PAGE_END);

		setTitle("Gloomhaven Secretariat Server");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void afterSingletonsInstantiated() {
		this.auhtKeyTable();

		this.setVisible(true);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setLabel() {
		if (ssl) {
			portLabel.setText("Port: " + port + " (HTTPS) / " + httpPort + " (HTTP)");
		} else {
			portLabel.setText("Port: " + port);
		}
		ipLabel.setText("IPs: " + String.join(", ", clientManager.getHosts().toArray(new String[] {})));
	}

	protected void auhtKeyTable() {
		if (tablePane != null) {
			this.remove(tablePane);
		}
		try {
			String[] columns = new String[] { "Game Code", "Permissions", "Game ID" };

			List<GameCode> gameCodes = manager.gameCodes();

			List<Object[]> dataList = new LinkedList<>();
			if (gameCodes != null) {
				for (GameCode gameCode : gameCodes) {
					Object[] result = new Object[3];
					result[0] = gameCode.getGameCode();
					result[1] = gameCode.getJsonPath();
					result[2] = gameCode.getGameId();
					dataList.add(result);
				}

				JTable table = new JTable(dataList.toArray(new Object[][] {}), columns);
				tablePane = new JScrollPane(table);
				this.add(BorderLayout.CENTER, tablePane);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@EventListener
	void checkClientOnStartup(ApplicationReadyEvent event) {
		checkClient();
	}

	void checkClient() {

		openClientButton.setVisible(false);
		List<String> hosts = clientManager.getHosts();
		int index = 0;
		boolean running = false;

		while (hosts.size() > index && !running) {
			if (clientManager.checkClientRunning(hosts.get(index))) {
				clientUrl = clientManager.getClientUrl(hosts.get(0));
				openClientButton.setText("Open Client: " + clientUrl);
				running = true;
				openClientButton.setVisible(true);
			} else if (ssl && clientManager.checkClientRunningHttpOnly(hosts.get(index))) {
				clientUrl = clientManager.getClientUrl(hosts.get(0), true);
				openClientButton.setText("Open Client: " + clientUrl);
				running = true;
				openClientButton.setVisible(true);
			} else {
				index++;
			}
		}
	}

}
