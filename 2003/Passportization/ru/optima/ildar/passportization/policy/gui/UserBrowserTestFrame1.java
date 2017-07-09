package ru.optima.ildar.passportization.policy.gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import ru.optima.ildar.passportization.policy.molel.*;

/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class UserBrowserTestFrame1 extends JFrame {
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	private JTextField textField;
	private JTextArea textArea;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	public UserBrowserTestFrame1() throws PersistenceException {
		setTitle("UserBrowserTest");
		setSize(WIDTH, HEIGHT);

		// the root of the class tree is Object
		root = new DefaultMutableTreeNode("All");
		try {
			// add this data to populate the tree with some data
			Vector allGroup = UserGroup.getListOfAllUserGroups();
			DefaultMutableTreeNode node;
			for (Iterator iter = allGroup.iterator(); iter.hasNext();) {
				UserGroup group = (UserGroup) iter.next();
				node = new DefaultMutableTreeNode(group);
				//System.out.println(group);
				root.add(node);
			}
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
		model = new DefaultTreeModel(root);
		tree = new JTree(model);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent event) {
				// the user selected a different node
				// --update description
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				UserGroup group = (UserGroup) selectedNode.getUserObject();
				String description = getFieldDescription(group);
				textArea.setText(description);
			}
		});
		// set up selection mode
		int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
		tree.getSelectionModel().setSelectionMode(mode);

		// this text area holds the class description
		textArea = new JTextArea();

		// add tree and text area to the content pane
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JScrollPane(tree));
		panel.add(new JScrollPane(textArea));

		getContentPane().add(panel, BorderLayout.CENTER);

		addTextField();
	}
	public static String getFieldDescription(UserGroup g) {
		// use reflection to find types and names of fields
		StringBuffer r = new StringBuffer();
		r.append("FD:" + g.getFd());
		r.append("\nCaption:");
		r.append(g.getCaption());
		r.append("\nGroupID:");
		r.append(g.getUserGroup_id());
		return r.toString();
	}

	public void addTextField() {
		JPanel panel = new JPanel();

		ActionListener addListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String text = textField.getText();
					Class.forName(text);
					// clear text field to indicate success
					textField.setText("");
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Class not found");
				}
			}
		};

		// new class names are typed into this text field
		textField = new JTextField(20);
		textField.addActionListener(addListener);
		panel.add(textField);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(addListener);
		panel.add(addButton);

		getContentPane().add(panel, BorderLayout.SOUTH);
	}

}
