package ru.optima.ildar.passportization.policy.gui;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
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
public class UserBrowserPanel_0 extends JPanel {
	private BrowserFrame_0 frame;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	//private JTextField textField;
	private JTextField userGroupID = new JTextField(10);
	private JTextField caption = new JTextField(10);
	private JTextField fd = new JTextField(10);
	private JTextField userID = new JTextField(10);
	private JTextField userName = new JTextField(10);
	private JTextField login = new JTextField(10);
	private JTextField password = new JTextField(10);

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	public UserBrowserPanel_0(final BrowserFrame_0 frame) throws PersistenceException {
		this.frame = frame;
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		buildModel();
		tree = new JTree(model);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent event) {
				// the user selected a different node
				// --update description
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				DefaultMutableTreeNode parentNode =
					(DefaultMutableTreeNode) selectedNode.getParent();
				Object o = selectedNode.getUserObject();
				if (o instanceof UserGroup) {
					getGroupDescription((UserGroup) o);
				} else if (o instanceof User) {
					UserGroup group = (UserGroup) parentNode.getUserObject();
					getUserDescription(group, (User) o);
				}
				try {
					frame.getPermPane().getModel().correctPerm();
				} catch (Exception e) {
				}
			}
		});
		// set up selection mode
		int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
		tree.getSelectionModel().setSelectionMode(mode);

		JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(2, 1));
		panel.setLayout(new BorderLayout());
		panel.add(new JScrollPane(tree));
		JPanel infoPane = new JPanel();
		infoPane.setLayout(new GridLayout(0, 2));
		infoPane.add(new JLabel("Код группы:"));
		userGroupID.setEditable(false);
		infoPane.add(userGroupID);
		infoPane.add(new JLabel("Название группы:"));
		infoPane.add(caption);
		infoPane.add(new JLabel("Дата создания:"));
		fd.setEditable(false);
		infoPane.add(fd);
		infoPane.add(new JLabel("Код пользователя:"));
		infoPane.add(userID);
		userID.setEditable(false);
		infoPane.add(new JLabel("Имя:"));
		infoPane.add(userName);
		infoPane.add(new JLabel("Логин:"));
		infoPane.add(login);
		infoPane.add(new JLabel("Пароль:"));
		infoPane.add(password);
		panel.add(infoPane, BorderLayout.SOUTH);

		add(panel, BorderLayout.CENTER);

		addButtonPanel();
	}
	private void buildModel() throws PersistenceException {
		// the root of the class tree is ""
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
				try {
					Vector users =
						User.getListUsersForGroup(group.getUserGroup_id().getIdAsString());
					for (Iterator iterator = users.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						node.add(new DefaultMutableTreeNode(user));
					}
				} catch (UserNotFoundException e) {
				}

			}
		} catch (Exception exp) {
			//throw new PersistenceException(exp.toString());
		}
		model = new DefaultTreeModel(root);
	}
	private void getGroupDescription(UserGroup group) {
		// use reflection to find types and names of fields
		userGroupID.setText(group.getUserGroup_id().getIdAsString());
		caption.setText(group.getCaption());
		fd.setText(group.getFd().toString());
		userID.setText("");
		userName.setText("");
		login.setText("");
		password.setText("");
	}
	private void getUserDescription(UserGroup group, User user) {
		// use reflection to find types and names of fields
		userGroupID.setText(user.getGroupID().toString());
		caption.setText(group.getCaption());
		userID.setText(user.getUser_id().getIdAsString());
		userName.setText(user.getName().toString());
		fd.setText(user.getFd().toString());
		login.setText(user.getLogin());
		password.setText(user.getPassword());
	}
	private void addButtonPanel() {
		JPanel panel = new JPanel();

		ActionListener addListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Date date = new Date(System.currentTimeMillis());
					String cap = caption.getText();
					String name = userName.getText();
					String log = login.getText();
					String pass = password.getText();
					DefaultMutableTreeNode newNode = null;
					if (cap.trim().equals(""))
						return;
					UserGroup group = new UserGroup(new UserGroup.UserGroupPK(), date, cap);
					newNode = findUserObject(group);
					if (newNode == null)
						group.store();
					else
						group = (UserGroup) newNode.getUserObject();
					User user = null;
					if (!name.trim().equals("")) {
						UserName uName = new UserName(name, "", "");
						Integer groupID = new Integer(group.getUserGroup_id().getIdAsString());
						user = new User(new User.UserPK(), date, uName, groupID, log, pass);
						user.store();
					}
					//rebuild tree
					buildModel();
					tree.setModel(model);
					if (user != null)
						newNode = findUserObject(user);
					else
						newNode = findUserObject(group);
					// make new node visible
					TreePath path = new TreePath(model.getPathToRoot(newNode));
					tree.scrollPathToVisible(path);
				} catch (PersistenceException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		};

		JButton addButton = new JButton("Доб");
		addButton.addActionListener(addListener);
		panel.add(addButton);

		ActionListener deleteListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TreePath path = tree.getSelectionPath();
					if (path == null)
						return;
					DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
					Object o = selectedNode.getUserObject();
					if (o instanceof UserGroup) {
						UserGroup.deleteWithUserGroupPK(((UserGroup) o).getUserGroup_id());
					} else if (o instanceof User) {
						User.deleteWithUserPK(((User) o).getUser_id());
					}
					//rebuild tree
					buildModel();
					tree.setModel(model);
				} catch (PersistenceException pe) {
					JOptionPane.showMessageDialog(null, pe);
				}
			}
		};

		JButton deleteButton = new JButton("Удал");
		deleteButton.addActionListener(deleteListener);
		panel.add(deleteButton);

		ActionListener updateListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TreePath path = tree.getSelectionPath();
					if (path == null)
						return;
					DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
					Object o = selectedNode.getUserObject();
					String cap = caption.getText();
					String name = userName.getText();
					String log = login.getText();
					String pass = password.getText();
					if (o instanceof UserGroup) {
						UserGroup old = (UserGroup) o;
						UserGroup group = new UserGroup(old.getUserGroup_id(), old.getFd(), cap);
						group.store();
						buildModel(); //rebuild tree
						tree.setModel(model);
						selectedNode = findUserObject(group);
					} else if (o instanceof User) {
						User old = (User) o;
						UserName Uname = new UserName(name, "", "");
						User user =
							new User(
								old.getUser_id(),
								old.getFd(),
								Uname,
								old.getGroupID(),
								log,
								pass);
						user.store();
						buildModel(); //rebuild tree
						tree.setModel(model);
						selectedNode = findUserObject(user);
					}
					// make new node visible
					path = new TreePath(model.getPathToRoot(selectedNode));
					tree.scrollPathToVisible(path);
				} catch (PersistenceException pe) {
					JOptionPane.showMessageDialog(null, pe);
				}
			}
		};

		JButton updateButton = new JButton("Изм");
		updateButton.addActionListener(updateListener);
		panel.add(updateButton);
		add(panel, BorderLayout.SOUTH);
	}

	/**
	   Finds an object in the tree.
	   @param obj the object to find
	   @return the node containing the object or null
	   if the object is not present in the tree
	*/
	private DefaultMutableTreeNode findUserObject(Object obj) {
		// find the node containing a user object
		Enumeration e = root.breadthFirstEnumeration();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
			if (node.getUserObject().equals(obj))
				return node;
		}
		return null;
	}

	public Object getSelectetObject() {
		TreePath path = tree.getSelectionPath();
		if (path == null)
			return null;
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
		return selectedNode.getUserObject();
	}
}
