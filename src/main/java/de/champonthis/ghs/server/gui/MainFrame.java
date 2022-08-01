/**
 * 
 */
package de.champonthis.ghs.server.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
	@Value("${server.port:8080}")
	private int port;

	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JLabel ipLabel = new JLabel();
	private JLabel portLabel = new JLabel();
	private JButton quitButton = new JButton("Quit");
	private JButton installButton = new JButton("Install latest Client");

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
			installButton.setEnabled(false);
			manager.installLatestClient();
			installButton.setEnabled(true);
		});

		bottomPanel.add(installButton, BorderLayout.WEST);

		quitButton.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		bottomPanel.add(BorderLayout.EAST, quitButton);

		this.add(bottomPanel, BorderLayout.PAGE_END);

		setTitle("Gloomhaven Secretary Server");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*
	 * @see org.springframework.beans.factory.SmartInitializingSingleton#
	 * afterSingletonsInstantiated()
	 */
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

		LinkedList<String> ips = new LinkedList<String>();
		ips.push("localhost");
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(localhost, port));
			ips.push(socket.getLocalAddress().getHostAddress());
			socket.close();

			socket = new Socket();
			socket.connect(new InetSocketAddress("champonthis.de", 443));
			ips.push(socket.getLocalAddress().getHostAddress());
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		ipLabel.setText("IPs: " + String.join(", ", ips.toArray(new String[] {})));
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

}
