/**
   @version 1.00 2001-07-18
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
   This program demonstrates how to show a simple table
*/
public class PlanetTable
{ 
   public static void main(String[] args)
   {  
      JFrame frame = new PlanetTableFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

/**
   This frame contains a table of planet data.
*/
class PlanetTableFrame extends JFrame
{  
   public PlanetTableFrame()
   {  
      setTitle("PlanetTable");
      setSize(WIDTH, HEIGHT);

      JTable table = new JTable(cells, columnNames);

      getContentPane().add(new JScrollPane(table), 
         BorderLayout.CENTER);
   }

   private Object[][] cells =
   {  
      { 
         "Mercury", new Double(2440),  new Integer(0),
         Boolean.FALSE, Color.yellow
      },
      { 
         "Venus", new Double(6052), new Integer(0),
         Boolean.FALSE, Color.yellow
      },
      { 
         "Earth", new Double(6378), new Integer(1),
         Boolean.FALSE, Color.blue
      },
      { 
         "Mars", new Double(3397), new Integer(2),
         Boolean.FALSE, Color.red
      },
      { 
         "Jupiter", new Double(71492), new Integer(16),
         Boolean.TRUE, Color.orange
      },
      { 
         "Saturn", new Double(60268), new Integer(18),
         Boolean.TRUE, Color.orange
      },
      { 
         "Uranus", new Double(25559), new Integer(17),
         Boolean.TRUE, Color.blue
      },
      { 
         "Neptune", new Double(24766), new Integer(8),
         Boolean.TRUE, Color.blue
      },
      { 
         "Pluto", new Double(1137), new Integer(1),
         Boolean.FALSE, Color.black
      }
   };

   private String[] columnNames =
   {  
      "Planet", "Radius", "Moons", "Gaseous", "Color"
   };

   private static final int WIDTH = 400;
   private static final int HEIGHT = 200;
}
