/**
 * 
 */
package de.champonthis.ghs.server.gui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.sql.ResultSet;
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

/**
 * The Class MainFrame.
 */
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

	/**
	 * Instantiates a new main frame.
	 */
	public MainFrame() {
		initUI();
	}

	/**
	 * Inits the UI.
	 */
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

		quitButton.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

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

	/**
	 * Sets the label.
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void setLabel() {
		portLabel.setText("Port: " + port);
		ipLabel.setText("IPs: " + String.join(", ", clientManager.getHosts().toArray(new String[] {})));
	}

	/**
	 * Auht key table.
	 */
	protected void auhtKeyTable() {
		try {
			String[] columns = new String[] { "Password", "Permissions", "Game ID" };

			ResultSet passwordResultSet = manager.passwords();

			List<Object[]> dataList = new LinkedList<Object[]>();
			if (passwordResultSet != null) {
				while (passwordResultSet.next()) {
					Object[] result = new Object[3];
					result[0] = passwordResultSet.getString("password");
					result[1] = passwordResultSet.getString("json_path");
					result[2] = passwordResultSet.getInt("game_id");
					dataList.add(result);
				}

				JTable table = new JTable(dataList.toArray(new Object[][] {}), columns);
				this.add(BorderLayout.CENTER, new JScrollPane(table));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check client on startup.
	 *
	 * @param event the event
	 */
	@EventListener
	void checkClientOnStartup(ApplicationReadyEvent event) {
		checkClient();
	}

	/**
	 * Check client.
	 */
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
