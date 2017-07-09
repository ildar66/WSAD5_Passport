package ru.optima.ildar.passportization.policy.gui;
import java.awt.GridLayout;
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
public class BrowserFrame_0 extends JFrame {
	public BrowserFrame_0() throws PersistenceException {
		setTitle("BrowserFrame");
		setSize(WIDTH, HEIGHT);
		getContentPane().setLayout(new GridLayout(1, 3));
		getContentPane().add(userPane);
		getContentPane().add(permPane);
		getContentPane().add(topPane);
	}
	private static final int WIDTH = 750;
	private static final int HEIGHT = 450;
	private UserBrowserPanel_0 userPane = new UserBrowserPanel_0(this);
	private TopicBrowserPanel_0 topPane = new TopicBrowserPanel_0(this);
	private PermissionPanel_0 permPane = new PermissionPanel_0(this);
	/**
	 * Returns the permPane.
	 * @return PermissionPanel
	 */
	public PermissionPanel_0 getPermPane() {
		return permPane;
	}

	/**
	 * Returns the topPane.
	 * @return TopicBrowserPanel
	 */
	public TopicBrowserPanel_0 getTopPane() {
		return topPane;
	}

	/**
	 * Returns the userPane.
	 * @return UserBrowserPanel
	 */
	public UserBrowserPanel_0 getUserPane() {
		return userPane;
	}

	/**
	 * Sets the permPane.
	 * @param permPane The permPane to set
	 */
	public void setPermPane(PermissionPanel_0 permPane) {
		this.permPane = permPane;
	}

	/**
	 * Sets the topPane.
	 * @param topPane The topPane to set
	 */
	public void setTopPane(TopicBrowserPanel_0 topPane) {
		this.topPane = topPane;
	}

	/**
	 * Sets the userPane.
	 * @param userPane The userPane to set
	 */
	public void setUserPane(UserBrowserPanel_0 userPane) {
		this.userPane = userPane;
	}

}
