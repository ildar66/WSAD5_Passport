/**
   @version 1.01 2001-07-17
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
   This program demonstrates tree editing.
*/
public class TreeEditTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new TreeEditFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   A frame with a tree and buttons to edit the tree.
*/
class TreeEditFrame extends JFrame
{  
   public TreeEditFrame()
   {  
      setTitle("TreeEditTest");
      setSize(WIDTH, HEIGHT);

      // construct tree

      TreeNode root = makeSampleTree();
      model = new DefaultTreeModel(root);
      tree = new JTree(model);
      tree.setEditable(true);

      // add scroll pane with tree to content pane

      JScrollPane scrollPane = new JScrollPane(tree);
      getContentPane().add(scrollPane, BorderLayout.CENTER);

      makeButtons();
      // make button panel

   }

   public TreeNode makeSampleTree()
   {  
      DefaultMutableTreeNode root
         = new DefaultMutableTreeNode("World");
      DefaultMutableTreeNode country
         = new DefaultMutableTreeNode("USA");
      root.add(country);
      DefaultMutableTreeNode state
         = new DefaultMutableTreeNode("California");
      country.add(state);
      DefaultMutableTreeNode city
         = new DefaultMutableTreeNode("San Jose");
      state.add(city);
      city = new DefaultMutableTreeNode("Cupertino");
      state.add(city);
      state = new DefaultMutableTreeNode("Michigan");
      country.add(state);
      city = new DefaultMutableTreeNode("Ann Arbor");
      state.add(city);
      country = new DefaultMutableTreeNode("Germany");
      root.add(country);
      state = new DefaultMutableTreeNode("Schleswig-Holstein");
      country.add(state);
      city = new DefaultMutableTreeNode("Kiel");
      state.add(city);
      return root;
   }

   /**
      Makes the buttons to add a sibling, add a child, and
      delete a node.
   */
   public void makeButtons()
   {
      JPanel panel = new JPanel();
      JButton addSiblingButton = new JButton("Add Sibling");
      addSiblingButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               DefaultMutableTreeNode selectedNode
                  = (DefaultMutableTreeNode)
                  tree.getLastSelectedPathComponent();

               if (selectedNode == null) return;

               DefaultMutableTreeNode parent
                  = (DefaultMutableTreeNode)
                  selectedNode.getParent();

               if (parent == null) return;

               DefaultMutableTreeNode newNode
                  = new DefaultMutableTreeNode("New"+next++);

               int selectedIndex = parent.getIndex(selectedNode);
               model.insertNodeInto(newNode, parent,
                  selectedIndex + 1);
         
               // now display new node
               
               TreeNode[] nodes = model.getPathToRoot(newNode);
               TreePath path = new TreePath(nodes);
               tree.scrollPathToVisible(path);
            }
         });
      panel.add(addSiblingButton);

      JButton addChildButton = new JButton("Add Child");
      addChildButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               DefaultMutableTreeNode selectedNode
                  = (DefaultMutableTreeNode)
                  tree.getLastSelectedPathComponent();

               if (selectedNode == null) return;

               DefaultMutableTreeNode newNode
                  = new DefaultMutableTreeNode("New");
               model.insertNodeInto(newNode, selectedNode,
                  selectedNode.getChildCount());               

               // now display new node
               
               TreeNode[] nodes = model.getPathToRoot(newNode);
               TreePath path = new TreePath(nodes);
               tree.scrollPathToVisible(path);
            }
         });
      panel.add(addChildButton);

      JButton deleteButton = new JButton("Delete");
      deleteButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               DefaultMutableTreeNode selectedNode
                  = (DefaultMutableTreeNode)
                  tree.getLastSelectedPathComponent();

               if (selectedNode != null && 
                  selectedNode.getParent() != null)
                  model.removeNodeFromParent(selectedNode);
            }
         });
      panel.add(deleteButton);
      getContentPane().add(panel, BorderLayout.SOUTH);
   }

   private DefaultTreeModel model;
   private JTree tree;
   private static final int WIDTH = 400;
   private static final int HEIGHT = 200;
   int next = 0;
}
