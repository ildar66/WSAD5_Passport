package ru.optima.ildar.passportization.policy.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.spec.KeySpec;

import javax.swing.*;
import ru.optima.ildar.passportization.policy.molel.*;
/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class BrowserFrame extends JFrame {
	private JButton addUserButton,
		delUserButton,
		updUserButton,
		addGroupButton,
		delGroupButton,
		updGroupButton,
		enableButton;
	private JMenuItem addUserItem,
		delUserItem,
		updUserItem,
		addGroupItem,
		delGroupItem,
		updGroupItem;
	private JLabel statusLabel = new JLabel(" ", JLabel.CENTER);
	;
	public BrowserFrame() throws PersistenceException {
		setTitle("BrowserFrame");
		setSize(WIDTH, HEIGHT);

		JPanel centerPane = new JPanel(new BorderLayout());
		JSplitPane innerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPane, permPane);
		JSplitPane outerPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, userPane, innerPane);
		centerPane.add(outerPane, BorderLayout.CENTER);
		getContentPane().add(centerPane, BorderLayout.CENTER);

		statusLabel.setForeground(java.awt.Color.red);
		getContentPane().add(statusLabel, BorderLayout.SOUTH);

		JToolBar bar = new JToolBar();
		bar.setMargin(new Insets(3, 3, 3, 3));
		Action addUserAct = userPane.new AddUserAction("Add User ");
		//addUserAct.putValue(Action.MNEMONIC_KEY, new Integer('u'));
		addUserButton = new JButton(addUserAct);
		addUserButton.setEnabled(false);
		bar.add(addUserButton);
		Action delUserAct = userPane.new DeleteUserAction("Delete User");
		delUserButton = new JButton(delUserAct);
		delUserButton.setEnabled(false);
		bar.add(delUserButton);
		Action updUserAct = userPane.new UpdateUserAction("Update User");
		updUserButton = new JButton(updUserAct);
		updUserButton.setEnabled(false);
		bar.add(updUserButton);
		bar.addSeparator();
		Action addGroupAct = userPane.new AddGroupAction("Add Group");
		addGroupButton = new JButton(addGroupAct);
		bar.add(addGroupButton);
		Action delGroupAct = userPane.new DeleteGroupAction("Delete Group");
		delGroupButton = new JButton(delGroupAct);
		delGroupButton.setEnabled(false);
		bar.add(delGroupButton);
		Action updGroupAct = userPane.new UpdateGroupAction("Update Group");
		updGroupButton = new JButton(updGroupAct);
		updGroupButton.setEnabled(false);
		bar.add(updGroupButton);
		Action exitAct = new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		};
		bar.addSeparator();
		enableButton = new JButton(userPane.new EnableGroupAction("Enable"));
		bar.addSeparator();
		bar.add(enableButton);
		bar.add(exitAct);
		getContentPane().add(bar, BorderLayout.NORTH);

		JMenu menuFile = new JMenu("Файл");
		menuFile.add(exitAct);
		JMenu menuUser = new JMenu("Пользователи");
		addUserItem = new JMenuItem(addUserAct);
		addUserItem.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
		addUserItem.setEnabled(false);
		menuUser.add(addUserItem);
		delUserItem = new JMenuItem(delUserAct);
		delUserItem.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
		delUserItem.setEnabled(false);
		menuUser.add(delUserItem);
		updUserItem = new JMenuItem(updUserAct);
		updUserItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		updUserItem.setEnabled(false);
		menuUser.add(updUserItem);

		JMenu menuGroup = new JMenu("Группы пользователей");
		addGroupItem = new JMenuItem(addGroupAct);
		addGroupItem.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
		menuGroup.add(addGroupItem);
		delGroupItem = new JMenuItem(delGroupAct);
		delGroupItem.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
		delGroupItem.setEnabled(false);
		menuGroup.add(delGroupItem);
		updGroupItem = new JMenuItem(updGroupAct);
		updGroupItem.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
		updGroupItem.setEnabled(false);
		menuGroup.add(updGroupItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuFile);
		menuBar.add(menuUser);
		menuBar.add(menuGroup);
		setJMenuBar(menuBar);
		//клавиши:
		InputMap imap = outerPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl U"), "user add");
		imap.put(KeyStroke.getKeyStroke("ctrl D"), "user delete");
		imap.put(KeyStroke.getKeyStroke("ctrl С"), "user update");
		imap.put(KeyStroke.getKeyStroke("ctrl G"), "group add");
		imap.put(KeyStroke.getKeyStroke("ctrl P"), "group update");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "group delete");

		ActionMap amap = outerPane.getActionMap();
		amap.put("user add", addUserAct);
		amap.put("user delete", delUserAct);
		amap.put("user update", updUserAct);
		amap.put("group add", addGroupAct);
		amap.put("group update", updGroupAct);
		amap.put("group delete", delGroupAct);

	}
	private static final int WIDTH = 750;
	private static final int HEIGHT = 450;
	private UserBrowserPanel userPane = new UserBrowserPanel(this);
	private TopicBrowserPanel topPane = new TopicBrowserPanel(this);
	private PermissionPanel permPane = new PermissionPanel(this);

	public PermissionPanel getPermPane() {
		return permPane;
	}

	public TopicBrowserPanel getTopPane() {
		return topPane;
	}

	public UserBrowserPanel getUserPane() {
		return userPane;
	}

	/**
	 * Returns the addUserButton.
	 * @return JButton
	 */
	public JButton getAddUserButton() {
		return addUserButton;
	}

	/**
	 * Returns the addGroupButton.
	 * @return JButton
	 */
	public JButton getAddGroupButton() {
		return addGroupButton;
	}

	/**
	 * Returns the delGroupButton.
	 * @return JButton
	 */
	public JButton getDelGroupButton() {
		return delGroupButton;
	}

	/**
	 * Returns the delUserButton.
	 * @return JButton
	 */
	public JButton getDelUserButton() {
		return delUserButton;
	}

	/**
	 * Returns the updGroupButton.
	 * @return JButton
	 */
	public JButton getUpdGroupButton() {
		return updGroupButton;
	}

	/**
	 * Returns the updUserButton.
	 * @return JButton
	 */
	public JButton getUpdUserButton() {
		return updUserButton;
	}

	/**
	 * Returns the addGroupItem.
	 * @return JMenuItem
	 */
	public JMenuItem getAddGroupItem() {
		return addGroupItem;
	}

	/**
	 * Returns the addUserItem.
	 * @return JMenuItem
	 */
	public JMenuItem getAddUserItem() {
		return addUserItem;
	}

	/**
	 * Returns the delGroupItem.
	 * @return JMenuItem
	 */
	public JMenuItem getDelGroupItem() {
		return delGroupItem;
	}

	/**
	 * Returns the delUserItem.
	 * @return JMenuItem
	 */
	public JMenuItem getDelUserItem() {
		return delUserItem;
	}

	/**
	 * Returns the updGroupItem.
	 * @return JMenuItem
	 */
	public JMenuItem getUpdGroupItem() {
		return updGroupItem;
	}

	/**
	 * Returns the updUserItem.
	 * @return JMenuItem
	 */
	public JMenuItem getUpdUserItem() {
		return updUserItem;
	}

	/**
	 * Returns the statusLabel.
	 * @return JLabel
	 */
	public JLabel getStatusLabel() {
		return statusLabel;
	}

}
