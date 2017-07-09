package ru.optima.ildar.passportization.policy.gui;

import javax.swing.JFrame;
import ru.optima.ildar.passportization.policy.molel.*;
/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class BrowserTest {
	public static void main(String[] args) throws PersistenceException {
		BrowserFrame frame = new BrowserFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}
