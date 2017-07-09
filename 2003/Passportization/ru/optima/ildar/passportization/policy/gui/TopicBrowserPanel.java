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
public class TopicBrowserPanel extends JPanel {
	private BrowserFrame frame;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	private JTree tree;
	//private JTextField textField;
	private JTextField topicID = new JTextField(10);
	private JTextField caption = new JTextField(10);
	private JTextField fd = new JTextField(10);
	private JTextField subtopicID = new JTextField(10);
	private JTextField subtopicName = new JTextField(10);

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	public TopicBrowserPanel(final BrowserFrame frame) throws PersistenceException {
		this.frame = frame;
		setLayout(new BorderLayout());
		setSize(WIDTH, HEIGHT);
		buildModel();
		tree = new JTree(model);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent event) {
				// the subtopic selected a different node
				// --update description
				TreePath path = tree.getSelectionPath();
				if (path == null)
					return;
				DefaultMutableTreeNode selectedNode =
					(DefaultMutableTreeNode) path.getLastPathComponent();
				DefaultMutableTreeNode parentNode =
					(DefaultMutableTreeNode) selectedNode.getParent();
				Object o = selectedNode.getUserObject();
				if (o instanceof Topic) {
					getTopicDescription((Topic) o);
				} else if (o instanceof SubTopic) {
					Topic group = (Topic) parentNode.getUserObject();
					getSubTopicDescription(group, (SubTopic) o);
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

		// add tree to the content pane
		add(new JScrollPane(tree), BorderLayout.CENTER);
        add(new JLabel("РАЗДЕЛЫ:", JLabel.CENTER), BorderLayout.NORTH)		;
		
		JPanel infoPane = new JPanel();
		infoPane.setLayout(new GridLayout(0, 2));
		infoPane.add(new JLabel("Код раздела:"));
		topicID.setEditable(false);
		infoPane.add(topicID);
		infoPane.add(new JLabel("Назв. раздела:"));
		infoPane.add(caption);
		infoPane.add(new JLabel("Дата создания:"));
		fd.setEditable(false);
		infoPane.add(fd);
		infoPane.add(new JLabel("Код подраздела:"));
		infoPane.add(subtopicID);
		subtopicID.setEditable(false);
		infoPane.add(new JLabel("Имя подраздела:"));
		infoPane.add(subtopicName);

		//addButtonPanel();
	}
	private void buildModel() throws PersistenceException {
		// the root of the class tree is Object
		root = new DefaultMutableTreeNode("All");
		try {
			// add this data to populate the tree with some data
			Vector allGroup = Topic.getListOfAllTopics();
			DefaultMutableTreeNode node;
			for (Iterator iter = allGroup.iterator(); iter.hasNext();) {
				Topic group = (Topic) iter.next();
				node = new DefaultMutableTreeNode(group);
				//System.out.println(group);
				root.add(node);
				try {
					Vector subtopics =
						SubTopic.getListSubTopicsForTopic(group.getTopic_id().getIdAsString());
					for (Iterator iterator = subtopics.iterator(); iterator.hasNext();) {
						SubTopic subtopic = (SubTopic) iterator.next();
						node.add(new DefaultMutableTreeNode(subtopic));
					}
				} catch (SubTopicNotFoundException e) {
				}

			}
		} catch (Exception exp) {
			//throw new PersistenceException(exp.toString());
		}
		model = new DefaultTreeModel(root);
	}
	private void getTopicDescription(Topic group) {
		// use reflection to find types and names of fields
		topicID.setText(group.getTopic_id().getIdAsString());
		caption.setText(group.getCaption());
		fd.setText(group.getFd().toString());
		subtopicID.setText("");
		subtopicName.setText("");
	}
	private void getSubTopicDescription(Topic group, SubTopic subtopic) {
		// use reflection to find types and names of fields
		topicID.setText(subtopic.getTopicID().toString());
		caption.setText(group.getCaption());
		subtopicID.setText(subtopic.getSubTopic_id().getIdAsString());
		subtopicName.setText(subtopic.getCaption());
		fd.setText(subtopic.getFd().toString());
	}
	private void addButtonPanel() {
		JPanel panel = new JPanel();

		ActionListener addListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Date date = new Date(System.currentTimeMillis());
					String cap = caption.getText();
					String name = subtopicName.getText();
					DefaultMutableTreeNode newNode = null;
					if (cap.trim().equals(""))
						return;
					Topic topic = new Topic(new Topic.TopicPK(), date, cap);
					newNode = findUserObject(topic);
					if (newNode == null)
						topic.store();
					else
						topic = (Topic) newNode.getUserObject();
					SubTopic subtopic = null;
					if (!name.trim().equals("")) {
						Integer topicID = new Integer(topic.getTopic_id().getIdAsString());
						subtopic = new SubTopic(new SubTopic.SubTopicPK(), date, topicID, name);
						subtopic.store();
					}
					//rebuild tree
					buildModel();
					tree.setModel(model);
					if (subtopic != null)
						newNode = findUserObject(subtopic);
					else
						newNode = findUserObject(topic);
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
					if (o instanceof Topic) {
						Topic.deleteWithTopicPK(((Topic) o).getTopic_id());
					} else if (o instanceof SubTopic) {
						SubTopic.deleteWithSubTopicPK(((SubTopic) o).getSubTopic_id());
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
					String name = subtopicName.getText();
					if (o instanceof Topic) {
						Topic old = (Topic) o;
						Topic group = new Topic(old.getTopic_id(), old.getFd(), cap);
						group.store();
						buildModel(); //rebuild tree
						tree.setModel(model);
						selectedNode = findUserObject(group);
					} else if (o instanceof SubTopic) {
						SubTopic old = (SubTopic) o;
						SubTopic subtopic =
							new SubTopic(old.getSubTopic_id(), old.getFd(), old.getTopicID(), name);
						subtopic.store();
						buildModel(); //rebuild tree
						tree.setModel(model);
						selectedNode = findUserObject(subtopic);
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
