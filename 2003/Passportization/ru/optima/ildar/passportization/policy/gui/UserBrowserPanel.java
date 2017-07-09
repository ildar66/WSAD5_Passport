package ru.optima.ildar.passportization.policy.gui;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.TextAction;
import javax.swing.tree.*;

import ru.optima.ildar.passportization.policy.molel.*;
import sun.awt.HorizBagLayout;

/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class UserBrowserPanel extends JPanel {
	private BrowserFrame frame;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	private CardLayout cardManager;
	private JPanel cardPane;
	private JTextField caption = new JTextField(10);
	private JTextField fdGroup = new JTextField(10);
	private JTextField fdUser = new JTextField(10);
	private JTextField userFName = new JTextField(10);
	private JTextField userMName = new JTextField(10);
	private JTextField userLName = new JTextField(10);
	private JTextField login = new JTextField(10);
	private JPasswordField password = new JPasswordField(10);
	private JPasswordField password1 = new JPasswordField(10);
	private String flag = "";
	private JButton saveG, canselG;
	private JButton saveUs, canselU;
	private JPopupMenu popupUser;
	private JPopupMenu popupGroup;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	public UserBrowserPanel(final BrowserFrame frame) throws PersistenceException {
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
				if (path == null) {
					frame.getUpdGroupButton().setEnabled(false);
					frame.getUpdUserButton().setEnabled(false);
					frame.getDelGroupButton().setEnabled(false);
					frame.getDelUserButton().setEnabled(false);
					frame.getAddUserButton().setEnabled(false);
					frame.getUpdGroupItem().setEnabled(false);
					frame.getUpdUserItem().setEnabled(false);
					frame.getDelGroupItem().setEnabled(false);
					frame.getDelUserItem().setEnabled(false);
					frame.getAddUserItem().setEnabled(false);
					return;
				}
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				DefaultMutableTreeNode parentNode =
					(DefaultMutableTreeNode) selectedNode.getParent();
				Object o = selectedNode.getUserObject();
				if (o instanceof UserGroup) {
					frame.getUpdGroupButton().setEnabled(true);
					frame.getUpdUserButton().setEnabled(false);
					frame.getDelGroupButton().setEnabled(true);
					frame.getDelUserButton().setEnabled(false);
					frame.getAddUserButton().setEnabled(true);
					frame.getUpdGroupItem().setEnabled(true);
					frame.getUpdUserItem().setEnabled(false);
					frame.getDelGroupItem().setEnabled(true);
					frame.getDelUserItem().setEnabled(false);
					frame.getAddUserItem().setEnabled(true);
					getGroupDescription((UserGroup) o);
					cardManager.show(cardPane, "infoGroupPanel");
				} else if (o instanceof User) {
					frame.getUpdGroupButton().setEnabled(false);
					frame.getUpdUserButton().setEnabled(true);
					frame.getDelGroupButton().setEnabled(false);
					frame.getDelUserButton().setEnabled(true);
					frame.getAddUserButton().setEnabled(true);
					frame.getUpdGroupItem().setEnabled(false);
					frame.getUpdUserItem().setEnabled(true);
					frame.getDelGroupItem().setEnabled(false);
					frame.getDelUserItem().setEnabled(true);
					frame.getAddUserItem().setEnabled(true);
					UserGroup group = (UserGroup) parentNode.getUserObject();
					getUserDescription(group, (User) o);
					cardManager.show(cardPane, "infoUserPanel");
				}
				try {
					frame.getPermPane().getModel().correctPerm();
				} catch (Exception e) {
				}
				frame.getStatusLabel().setText(" ");
			}
		});
		// set up selection mode
		int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
		tree.getSelectionModel().setSelectionMode(mode);
		add(new JLabel("ГРУППЫ ПОЛЬЗОВАТЕЛЕЙ:", JLabel.CENTER), BorderLayout.NORTH);
		add(new JScrollPane(tree), BorderLayout.CENTER);

		//информация о пользователе:
		JPanel infoUserPanel = new JPanel(new BorderLayout());
		infoUserPanel.add(
			new JLabel("Информация о пользователе:", JLabel.CENTER),
			BorderLayout.NORTH);
		JPanel userPane = new JPanel(new GridLayout(0, 2));
		userPane.add(new JLabel("Фамилия:"));
		userLName.setEditable(false);
		userPane.add(userLName);
		userPane.add(new JLabel("Имя:"));
		userFName.setEditable(false);
		userPane.add(userFName);
		userPane.add(new JLabel("Отчество:"));
		userMName.setEditable(false);
		userPane.add(userMName);
		userPane.add(new JLabel("Логин:"));
		login.setEditable(false);
		userPane.add(login);
		userPane.add(new JLabel("Пароль:"));
		password.setEditable(false);
		userPane.add(password);
		userPane.add(new JLabel("Пароль еще раз:"));
		password1.setEditable(false);
		userPane.add(password1);
		userPane.add(new JLabel("Дата создания пользователя:"));
		fdUser.setEditable(false);
		userPane.add(fdUser);
		infoUserPanel.add(userPane, BorderLayout.CENTER);
		JPanel userButtonPane = new JPanel();
		saveUs = new JButton(new SaveUserAction("Сохранить"));
		canselU = new JButton(new CanselUserAction("Отменить"));
		saveUs.setEnabled(false);
		canselU.setEnabled(false);
		userButtonPane.add(saveUs);
		userButtonPane.add(canselU);
		infoUserPanel.add(userButtonPane, BorderLayout.SOUTH);

		//информация о группе:
		JPanel infoGroupPanel = new JPanel(new BorderLayout());
		infoGroupPanel.add(new JLabel("Информация о группе:", JLabel.CENTER), BorderLayout.NORTH);
		JPanel groupPane = new JPanel(new GridLayout(7, 2));
		groupPane.add(new JLabel("Название группы:"));
		caption.setEditable(false);
		groupPane.add(caption);
		groupPane.add(new JLabel("Дата создания группы:"));
		fdGroup.setEditable(false);
		groupPane.add(fdGroup);
		infoGroupPanel.add(groupPane, BorderLayout.CENTER);
		JPanel groupButtonPane = new JPanel();
		saveG = new JButton(new SaveGroupAction("Сохранить"));
		canselG = new JButton(new CanselGroupAction("Отменить"));
		saveG.setEnabled(false);
		canselG.setEnabled(false);
		groupButtonPane.add(saveG);
		groupButtonPane.add(canselG);
		infoGroupPanel.add(groupButtonPane, BorderLayout.SOUTH);

		cardManager = new CardLayout();
		cardPane = new JPanel(cardManager);
		cardPane.add(infoGroupPanel, "infoGroupPanel");
		cardPane.add(infoUserPanel, "infoUserPanel");
		add(cardPane, BorderLayout.SOUTH);
		//add(infoPanel, BorderLayout.SOUTH);
		//addButtonPanel();
		//всплывающее меню
		popupUser = new JPopupMenu();
		popupUser.add(new AddUserAction("Добавить пользователя"));
		popupUser.add(new UpdateUserAction("Изменить пользователя"));
		popupUser.add(new DeleteUserAction("Удалить пользователя"));
		popupGroup = new JPopupMenu();
		popupGroup.add(new AddGroupAction("Добавить группу"));
		popupGroup.add(new UpdateGroupAction("Изменить группу"));
		popupGroup.add(new DeleteGroupAction("Удалить группу"));

		tree.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					//popupUser.show(e.getComponent(), e.getX(), e.getY());
					TreePath path = tree.getSelectionPath();
					if (path == null)
						return;
					DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
					Object o = selectedNode.getUserObject();
					if (o instanceof UserGroup) {
						popupGroup.show(e.getComponent(), e.getX(), e.getY());
					} else if (o instanceof User) {
						popupUser.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					//popupUser.show(e.getComponent(), e.getX(), e.getY());
					TreePath path = tree.getSelectionPath();
					if (path == null)
						return;
					DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
					Object o = selectedNode.getUserObject();
					if (o instanceof UserGroup) {
						popupGroup.show(e.getComponent(), e.getX(), e.getY());
					} else if (o instanceof User) {
						popupUser.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}

		});
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
		caption.setText(group.getCaption());
		fdGroup.setText(group.getFd().toString());
		userLName.setText("");
		userFName.setText("");
		userMName.setText("");
		login.setText("");
		password.setText("");
		password1.setText("");
		fdUser.setText("");
	}
	private void getUserDescription(UserGroup group, User user) {
		// use reflection to find types and names of fields
		caption.setText(group.getCaption());
		fdGroup.setText(group.getFd().toString());
		userLName.setText(user.getName().getLastName());
		userFName.setText(user.getName().getFirstName());
		userMName.setText(user.getName().getMiddleName());
		fdUser.setText(user.getFd().toString());
		login.setText(user.getLogin());
		password.setText(user.getPassword());
		password1.setText("");
	}
	private void addButtonPanel() {
		JPanel panel = new JPanel();

		ActionListener addListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Date date = new Date(System.currentTimeMillis());
					String cap = caption.getText();
					String Lname = userLName.getText();
					String Fname = userFName.getText();
					String Mname = userMName.getText();
					String log = login.getText();
					String pass = new String(password.getPassword());
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
					if (!Lname.trim().equals("")) {
						UserName uName = new UserName(Lname, Mname, Fname);
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
					String Lname = userLName.getText();
					String Fname = userFName.getText();
					String Mname = userMName.getText();
					String log = login.getText();
					String pass = new String(password.getPassword());
					if (o instanceof UserGroup) {
						UserGroup old = (UserGroup) o;
						UserGroup group = new UserGroup(old.getUserGroup_id(), old.getFd(), cap);
						group.store();
						buildModel(); //rebuild tree
						tree.setModel(model);
						selectedNode = findUserObject(group);
					} else if (o instanceof User) {
						User old = (User) o;
						UserName Uname = new UserName(Lname, Mname, Fname);
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

	class AddUserAction extends AbstractAction {
		public AddUserAction(String name) {
			super(name);
			putValue(Action.MNEMONIC_KEY, new Integer('u'));
		}
		public void actionPerformed(ActionEvent arg0) {
			userLName.setEditable(true);
			userFName.setEditable(true);
			userMName.setEditable(true);
			login.setEditable(true);
			password.setEditable(true);
			password1.setEditable(true);
			saveUs.setEnabled(true);
			canselU.setEnabled(true);
			userLName.requestFocus();
			userLName.setText("");
			userFName.setText("");
			userMName.setText("");
			login.setText("");
			password.setText("");
			password1.setText("");
			fdUser.setText(new Date(System.currentTimeMillis()).toString());
			flag = "ADD";
			cardManager.show(cardPane, "infoUserPanel");
		}
	}
	class UpdateUserAction extends AbstractAction {
		public UpdateUserAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			userLName.setEditable(true);
			userFName.setEditable(true);
			userMName.setEditable(true);
			login.setEditable(true);
			password.setEditable(true);
			password1.setEditable(true);
			saveUs.setEnabled(true);
			canselU.setEnabled(true);
			userLName.requestFocus();
			fdUser.setText(new Date(System.currentTimeMillis()).toString());
			flag = "UPDATE";
			cardManager.show(cardPane, "infoUserPanel");
		}
	}
	class DeleteUserAction extends AbstractAction {
		public DeleteUserAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				Object o = selectedNode.getUserObject();
				if (o instanceof UserGroup) {
					//UserGroup.deleteWithUserGroupPK(((UserGroup) o).getUserGroup_id());
					return;
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
	}

	class AddGroupAction extends AbstractAction {
		public AddGroupAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			caption.setEditable(true);
			saveG.setEnabled(true);
			canselG.setEnabled(true);
			caption.requestFocus();
			caption.setText("");
			caption.requestFocus();
			fdGroup.setText(new Date(System.currentTimeMillis()).toString());
			flag = "ADD";
			cardManager.show(cardPane, "infoGroupPanel");
		}
	}
	class DeleteGroupAction extends AbstractAction {
		public DeleteGroupAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				Object o = selectedNode.getUserObject();
				if (o instanceof UserGroup) {
					UserGroup.deleteWithUserGroupPK(((UserGroup) o).getUserGroup_id());
					caption.setText("");
					fdGroup.setText("");
				} else if (o instanceof User) {
					//User.deleteWithUserPK(((User) o).getUser_id());
					return;
				}
				//rebuild tree
				buildModel();
				tree.setModel(model);
			} catch (PersistenceException pe) {
				JOptionPane.showMessageDialog(null, pe);
			}
		}
	}
	class EnableGroupAction extends AbstractAction {
		public EnableGroupAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				Object o = selectedNode.getUserObject();
				if (o instanceof UserGroup) {
					//UserGroup.deleteWithUserGroupPK(((UserGroup) o).getUserGroup_id());
				} else if (o instanceof User) {
					User user = (User) o;
					user.setEnable(1);
					return;
				}
				//rebuild tree
				//buildModel();
				//tree.setModel(model);
			} catch (PersistenceException pe) {
				JOptionPane.showMessageDialog(null, pe);
			}
		}
	}
	class UpdateGroupAction extends AbstractAction {
		public UpdateGroupAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			caption.setEditable(true);
			saveG.setEnabled(true);
			canselG.setEnabled(true);
			caption.requestFocus();
			flag = "UPDATE";
			cardManager.show(cardPane, "infoGroupPanel");
		}
	}
	class SaveGroupAction extends AbstractAction {
		public SaveGroupAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (flag.equals("ADD")) {
					Date date = new Date(System.currentTimeMillis());
					String cap = caption.getText();
					DefaultMutableTreeNode newNode = null;
					if (cap.trim().equals("")) {
						caption.setText("!!!Введите название");
						caption.requestFocus();
						return;
					}
					UserGroup group = new UserGroup(new UserGroup.UserGroupPK(), date, cap);
					newNode = findUserObject(group);
					if (newNode == null)
						group.store();
					else
						group = (UserGroup) newNode.getUserObject();
					//rebuild tree
					buildModel();
					tree.setModel(model);
					newNode = findUserObject(group);
					// make new node visible
					TreePath path = new TreePath(model.getPathToRoot(newNode));
					tree.scrollPathToVisible(path);
				} else if (flag.equals("UPDATE")) {
					TreePath path = tree.getSelectionPath();
					if (path == null)
						return;
					DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
					Object o = selectedNode.getUserObject();
					String cap = caption.getText();
					if (o instanceof User)
						return;
					UserGroup old = (UserGroup) o;
					UserGroup group = new UserGroup(old.getUserGroup_id(), old.getFd(), cap);
					group.store();
					buildModel(); //rebuild tree
					tree.setModel(model);
					selectedNode = findUserObject(group);
					// make new node visible
					path = new TreePath(model.getPathToRoot(selectedNode));
					tree.scrollPathToVisible(path);
				}
				caption.setText("");
				caption.setEditable(false);
				fdGroup.setText("");
				saveG.setEnabled(false);
				canselG.setEnabled(false);
			} catch (PersistenceException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	class CanselGroupAction extends AbstractAction {
		public CanselGroupAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			TreePath path = tree.getSelectionPath();
			if (path == null) {
				frame.getUpdGroupButton().setEnabled(false);
				frame.getUpdUserButton().setEnabled(false);
				frame.getDelGroupButton().setEnabled(false);
				frame.getDelUserButton().setEnabled(false);
				frame.getAddUserButton().setEnabled(false);
				frame.getUpdGroupItem().setEnabled(false);
				frame.getUpdUserItem().setEnabled(false);
				frame.getDelGroupItem().setEnabled(false);
				frame.getDelUserItem().setEnabled(false);
				frame.getAddUserItem().setEnabled(false);
				return;
			}
			DefaultMutableTreeNode selectedNode =
				(DefaultMutableTreeNode) path.getLastPathComponent();
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
			Object o = selectedNode.getUserObject();
			if (o instanceof UserGroup) {
				frame.getUpdGroupButton().setEnabled(true);
				frame.getUpdUserButton().setEnabled(false);
				frame.getDelGroupButton().setEnabled(true);
				frame.getDelUserButton().setEnabled(false);
				frame.getAddUserButton().setEnabled(true);
				frame.getUpdGroupItem().setEnabled(true);
				frame.getUpdUserItem().setEnabled(false);
				frame.getDelGroupItem().setEnabled(true);
				frame.getDelUserItem().setEnabled(false);
				frame.getAddUserItem().setEnabled(true);
				getGroupDescription((UserGroup) o);
				cardManager.show(cardPane, "infoGroupPanel");
			} else if (o instanceof User) {
				frame.getUpdGroupButton().setEnabled(false);
				frame.getUpdUserButton().setEnabled(true);
				frame.getDelGroupButton().setEnabled(false);
				frame.getDelUserButton().setEnabled(true);
				frame.getAddUserButton().setEnabled(true);
				frame.getUpdGroupItem().setEnabled(false);
				frame.getUpdUserItem().setEnabled(true);
				frame.getDelGroupItem().setEnabled(false);
				frame.getDelUserItem().setEnabled(true);
				frame.getAddUserItem().setEnabled(true);
				UserGroup group = (UserGroup) parentNode.getUserObject();
				getUserDescription(group, (User) o);
				cardManager.show(cardPane, "infoUserPanel");
			}
			try {
				frame.getPermPane().getModel().correctPerm();
			} catch (Exception e) {
			}
			caption.setEditable(false);
			saveG.setEnabled(false);
			canselG.setEnabled(false);
		}
	}
	class SaveUserAction extends AbstractAction {
		public SaveUserAction(String name) {
			super(name);
			//putValue(Action.ACCELERATOR_KEY, key);
		}
		public void actionPerformed(ActionEvent arg0) {
			try {
				if (flag.equals("ADD")) {
					Date date = new Date(System.currentTimeMillis());
					String cap = caption.getText();
					String Lname = userLName.getText();
					String Fname = userFName.getText();
					String Mname = userMName.getText();
					String log = login.getText();
					String pass = new String(password.getPassword());
					String pass1 = new String(password1.getPassword());
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
					if (!Lname.trim().equals("")) {
						if (!pass.equals(pass1)) {
							password.setText("");
							password1.setText("");
							password.requestFocus();
							frame.getStatusLabel().setText("!!!Введите пароль повторно");
							return;
						}
						UserName uName = new UserName(Lname, Mname, Fname);
						Integer groupID = new Integer(group.getUserGroup_id().getIdAsString());
						user = new User(new User.UserPK(), date, uName, groupID, log, pass);
						newNode = findUserObject(user);
						if (newNode == null)
							user.store();
						else
							user = (User) newNode.getUserObject();
					} else {
						userLName.setText("!!!Введите текст");
						userLName.selectAll();
						userLName.requestFocus();
						return;
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
				} else if (flag.equals("UPDATE")) {
					TreePath path = tree.getSelectionPath();
					if (path == null)
						return;
					DefaultMutableTreeNode selectedNode =
						(DefaultMutableTreeNode) path.getLastPathComponent();
					Object o = selectedNode.getUserObject();
					String cap = caption.getText();
					String Lname = userLName.getText();
					String Fname = userFName.getText();
					String Mname = userMName.getText();
					String log = login.getText();
					String pass = new String(password.getPassword());
					String pass1 = new String(password1.getPassword());
					if ((!pass1.equals("")) && (!pass.equals(pass1))) {
						password.setText("");
						password1.setText("");
						password.requestFocus();
						frame.getStatusLabel().setText("!!!Введите пароль повторно");
						return;
					}
					if (o instanceof UserGroup) {
						UserGroup old = (UserGroup) o;
						UserGroup group = new UserGroup(old.getUserGroup_id(), old.getFd(), cap);
						group.store();
						buildModel(); //rebuild tree
						tree.setModel(model);
						selectedNode = findUserObject(group);
					} else if (o instanceof User) {
						User old = (User) o;
						UserName Uname = new UserName(Lname, Mname, Fname);
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
				}
				userLName.setEditable(false);
				userFName.setEditable(false);
				userMName.setEditable(false);
				login.setEditable(false);
				password.setEditable(false);
				password1.setEditable(false);
				saveUs.setEnabled(false);
				canselU.setEnabled(false);
			} catch (PersistenceException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	class CanselUserAction extends AbstractAction {
		public CanselUserAction(String name) {
			super(name);
		}
		public void actionPerformed(ActionEvent arg0) {
			TreePath path = tree.getSelectionPath();
			if (path == null) {
				frame.getUpdGroupButton().setEnabled(false);
				frame.getUpdUserButton().setEnabled(false);
				frame.getDelGroupButton().setEnabled(false);
				frame.getDelUserButton().setEnabled(false);
				frame.getAddUserButton().setEnabled(false);
				frame.getUpdGroupItem().setEnabled(false);
				frame.getUpdUserItem().setEnabled(false);
				frame.getDelGroupItem().setEnabled(false);
				frame.getDelUserItem().setEnabled(false);
				frame.getAddUserItem().setEnabled(false);
				return;
			}
			DefaultMutableTreeNode selectedNode =
				(DefaultMutableTreeNode) path.getLastPathComponent();
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
			Object o = selectedNode.getUserObject();
			if (o instanceof UserGroup) {
				frame.getUpdGroupButton().setEnabled(true);
				frame.getUpdUserButton().setEnabled(false);
				frame.getDelGroupButton().setEnabled(true);
				frame.getDelUserButton().setEnabled(false);
				frame.getAddUserButton().setEnabled(true);
				frame.getUpdGroupItem().setEnabled(true);
				frame.getUpdUserItem().setEnabled(false);
				frame.getDelGroupItem().setEnabled(true);
				frame.getDelUserItem().setEnabled(false);
				frame.getAddUserItem().setEnabled(true);
				getGroupDescription((UserGroup) o);
				cardManager.show(cardPane, "infoGroupPanel");
			} else if (o instanceof User) {
				frame.getUpdGroupButton().setEnabled(false);
				frame.getUpdUserButton().setEnabled(true);
				frame.getDelGroupButton().setEnabled(false);
				frame.getDelUserButton().setEnabled(true);
				frame.getAddUserButton().setEnabled(true);
				frame.getUpdGroupItem().setEnabled(false);
				frame.getUpdUserItem().setEnabled(true);
				frame.getDelGroupItem().setEnabled(false);
				frame.getDelUserItem().setEnabled(true);
				frame.getAddUserItem().setEnabled(true);
				UserGroup group = (UserGroup) parentNode.getUserObject();
				getUserDescription(group, (User) o);
				cardManager.show(cardPane, "infoUserPanel");
			}
			try {
				frame.getPermPane().getModel().correctPerm();
			} catch (Exception e) {
			}
			userLName.setEditable(false);
			userFName.setEditable(false);
			userMName.setEditable(false);
			login.setEditable(false);
			password.setEditable(false);
			password1.setEditable(false);
			saveUs.setEnabled(false);
			canselU.setEnabled(false);
		}
	}
}
