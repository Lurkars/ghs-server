/**
 * 
 */
package de.champonthis.ghs.server.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import de.champonthis.ghs.server.businesslogic.GameManager;

/**
 * The Class MainFrame.
 */
@Component
@Conditional(GuiCondition.class)
public class MainFrame extends JFrame implements SmartInitializingSingleton {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GameManager gameManager;

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

		var quitButton = new JButton("Quit");

		quitButton.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		this.add(BorderLayout.PAGE_END, quitButton);

		setTitle("Gloomhaven Secretary Server");
		setSize(300, 300);
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
	 * Auht key table.
	 */
	protected void auhtKeyTable() {

		try {
			String[] columns = new String[] { "Password", "JSON Path", "Game ID" };

			ResultSet passwordResultSet = gameManager.passwords();

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
				this.add(BorderLayout.PAGE_START, new JScrollPane(table));
			}
		} catch (Exception e) {

		}
	}

}
