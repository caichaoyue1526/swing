package border;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BorderFrame extends JFrame
{
   private JPanel demoPanel;
   private JPanel buttonPanel;
   private ButtonGroup group;

   public BorderFrame()
   {
      demoPanel = new JPanel();
      buttonPanel = new JPanel();
      group = new ButtonGroup();
      
      addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
      addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
      addRadioButton("Etched", BorderFactory.createEtchedBorder());
      addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
      addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
      addRadioButton("Empty", BorderFactory.createEmptyBorder());

      javax.swing.border.Border etched = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE);
      javax.swing.border.Border titled = BorderFactory.createTitledBorder(etched, "Border types");
      buttonPanel.setBorder(titled);

      setLayout(new GridLayout(2, 1));
      add(buttonPanel);
      add(demoPanel);
      pack();
   }

   public void addRadioButton(String buttonName, final javax.swing.border.Border b)
   {
      JRadioButton button = new JRadioButton(buttonName);
      button.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               demoPanel.setBorder(b);
            }
         });
      group.add(button);
      buttonPanel.add(button);
   }
}
