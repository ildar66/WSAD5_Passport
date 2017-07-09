package ru.optima.ildar.passportization.policy.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class IntCheckBox extends JCheckBox {
	private int id;
	public static void main(java.lang.String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		JCheckBox cb = new JCheckBox();
		cb.setName("Name1");
		cb.setText("Text1");
		JCheckBox cb2 = new JCheckBox("Text2");
		/**
		cb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				IntCheckBox icb = (IntCheckBox) e.getSource();
				//System.out.println("StateChang id=" + icb.getId());
			}
		});
		*/
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox icb = (JCheckBox) e.getSource();
				System.out.println("Action Name=" + icb.getName() + ":" + icb.isSelected());
			}
		};

		cb.addActionListener(al);
		cb2.addActionListener(al);
		JPanel panel = new JPanel();
		panel.add(cb);
		panel.add(cb2);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
	public IntCheckBox(int id) {
		this.id = id;
	}
	/**
	 * Returns the id.
	 * @return int
	 */
	public int getId() {
		return id;
	}

}
