package ru.optima.ildar.passportization.policy.gui;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.*;

import ru.optima.ildar.passportization.policy.molel.*;
import ru.optima.ildar.passportization.policy.molel.Permission;
;

public class PermissionPanel extends JPanel {
	private BrowserFrame frame;
	private JTextField permissionID = new JTextField(10);
	private JTextField caption = new JTextField(10);
	private JTextField fd = new JTextField(10);
	private JTable table;
	private JScrollPane scrollPane;
	private PermTableModel model;
	private JPanel panelC = new JPanel();
	private ListSelectionListener listener;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	public PermissionPanel(final BrowserFrame frame) throws PersistenceException {
		this.frame = frame;
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		// add table and info to the content pane
		//panel = new JPanel();
		panelC.setLayout(new BorderLayout());
		model = new PermTableModel();
		table = new JTable(model);
		//table.setName("Table");
		listener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int n = table.getSelectedRow();
				Permission perm = (Permission) model.getValueAt(n, PermTableModel.NAME_COLUMN);
				permissionID.setText(perm.getPermission_id().getIdAsString());
				caption.setText(perm.getCaption());
				fd.setText(perm.getFd().toString());
				if (model.permGroup.contains(perm.getPermission_id().getIdAsString()))
					frame.getStatusLabel().setText("Это полномочие группы: его нельзя изменить");
				else
					frame.getStatusLabel().setText(" ");
			}
		};
		// set up selection mode
		int mode = ListSelectionModel.SINGLE_SELECTION;
		table.getSelectionModel().setSelectionMode(mode);

		table.getSelectionModel().addListSelectionListener(listener);
		scrollPane = new JScrollPane(table);
		panelC.add(scrollPane);
		//add INFO PANEL
		JPanel infoPane = new JPanel();
		infoPane.setLayout(new GridLayout(0, 2));
		infoPane.add(new JLabel("Код полномочия:"));
		permissionID.setEditable(false);
		infoPane.add(permissionID);
		infoPane.add(new JLabel("Имя полномочия:"));
		infoPane.add(caption);
		infoPane.add(new JLabel("Дата создания:"));
		fd.setEditable(false);
		infoPane.add(fd);

		//panelC.add(infoPane, BorderLayout.SOUTH);

		add(panelC, BorderLayout.CENTER);
		add(new JLabel("ПОЛНОМОЧИЯ ПОЛЬЗОВАТЕЛЯ:", JLabel.CENTER), BorderLayout.NORTH);

		//addButtonPanel();
	}
	private void getDescription() {
		// use reflection to find types and names of fields
		//permissionID.setText(group.getTopic_id().getIdAsString());
		//caption.setText(group.getCaption());
		//fd.setText(group.getFd().toString());
	}

	private void addButtonPanel() {
		JPanel panel = new JPanel();

		ActionListener addListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Date date = new Date(System.currentTimeMillis());
					String cap = caption.getText();

					if (cap.trim().equals(""))
						return;
					Permission perm = new Permission(new Permission.PermissionPK(), date, cap);
					perm.store();
					rebuildTable();
					model.correctPerm();
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
					int n = table.getSelectedRow();
					if (n == -1)
						return;
					Permission perm = (Permission) model.getValueAt(n, PermTableModel.NAME_COLUMN);
					Permission.deleteWithPermissionPK(perm.getPermission_id());
					rebuildTable();
					model.correctPerm();
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
					int n = table.getSelectedRow();
					if (n == -1)
						return;
					Permission perm = (Permission) model.getValueAt(n, PermTableModel.NAME_COLUMN);
					String cap = caption.getText();
					perm.setCaption(cap);
					perm.store();
					rebuildTable();
					model.correctPerm();
					// make visible

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
	private void rebuildTable() { //rebuild table
		panelC.remove(scrollPane);
		model = new PermTableModel();
		table = new JTable(model);
		table.getSelectionModel().addListSelectionListener(listener);
		scrollPane = new JScrollPane(table);
		panelC.add(scrollPane);
		panelC.doLayout();
		// set up selection mode
		int mode = ListSelectionModel.SINGLE_SELECTION;
		table.getSelectionModel().setSelectionMode(mode);
	}
	class PermTableModel extends AbstractTableModel {
		PermTableModel() {
			try {
				permV = Permission.getListOfAllPermissions();
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		public String getColumnName(int c) {
			return columnNames[c];
		}

		public Class getColumnClass(int c) {
			if (c == NAME_COLUMN)
				return Permission.class;
			else
				return Boolean.class;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return permV.size();
		}

		public Object getValueAt(int r, int c) {
			if (c == NAME_COLUMN)
				return permV.elementAt(r);
			else {
				String idStr = ((Permission) permV.elementAt(r)).getPermission_id().getIdAsString();
				if (perm.contains(idStr))
					return Boolean.TRUE;
				else
					return Boolean.FALSE;
			}
		}

		public void setValueAt(Object obj, int r, int c) {
			//System.out.println("value:" + obj + " row:" + r + " colm:" + c);
			try {
				if (c == PERM_COLUMN) {
					Object ug = frame.getUserPane().getSelectetObject();
					Object st = frame.getTopPane().getSelectetObject();
					if (ug == null || st == null || (st instanceof Topic)) {
						return;
					}
					Boolean bool = (Boolean) obj;
					String idStr =
						((Permission) permV.elementAt(r)).getPermission_id().getIdAsString();
					String subTopicID = ((SubTopic) st).getSubTopic_id().getIdAsString();
					if (ug instanceof UserGroup) {
						UserGroup group = (UserGroup) ug;
						String groupID = group.getUserGroup_id().getIdAsString();
						if (bool.equals(Boolean.TRUE)) {
							Permission.addGroupPerm(groupID, subTopicID, idStr);
							perm.add(idStr);
						} else {
							Permission.deleteGroupPerm(groupID, subTopicID, idStr);
							perm.remove(idStr);
						}
					} else {
						User user = (User) ug;
						String userID = user.getUser_id().getIdAsString();
						if (bool.equals(Boolean.TRUE)) {
							Permission.addUserPerm(userID, subTopicID, idStr);
							perm.add(idStr);
						} else {
							Permission.deleteUserPerm(userID, subTopicID, idStr);
							perm.remove(idStr);
						}
					}
				}

			} catch (PersistenceException pe) {
				JOptionPane.showMessageDialog(null, pe);
			}
		}

		public boolean isCellEditable(int r, int c) {
			if (c == NAME_COLUMN)
				return false;
			else {
				String idStr = ((Permission) permV.elementAt(r)).getPermission_id().getIdAsString();
				if (permGroup.contains(idStr))
					return false;
				else
					return true;
			}
		}

		public static final int PERM_COLUMN = 0;
		public static final int NAME_COLUMN = 1;

		private Vector perm = new Vector();
		private Vector permGroup = new Vector();
		private Vector permV = new Vector();
		private String[] columnNames = { "Права", "Название прав" };

		public void correctPerm() throws PersistenceException {
			Object ug = frame.getUserPane().getSelectetObject();
			Object st = frame.getTopPane().getSelectetObject();
			if (ug == null || st == null || (st instanceof Topic)) {
				perm = new Vector();
				fireTableDataChanged();
				return;
			}
			String subTopicID = ((SubTopic) st).getSubTopic_id().getIdAsString();
			if (ug instanceof UserGroup) {
				UserGroup group = (UserGroup) ug;
				String groupID = group.getUserGroup_id().getIdAsString();
				perm = Permission.getListGroupPermForSubTopic(groupID, subTopicID);
				permGroup = new Vector();
			} else {
				User user = (User) ug;
				String userID = user.getUser_id().getIdAsString();
				String groupID = user.getGroupID().toString();
				perm = Permission.getListUserPermForSubTopic(userID, subTopicID);
				permGroup = Permission.getListGroupPermForSubTopic(groupID, subTopicID);
				perm.addAll(permGroup);
			}
			fireTableDataChanged();
		}
	}

	/**
	 * Returns the model.
	 * @return PermTableModel
	 */
	public PermTableModel getModel() {
		return model;
	}

}
