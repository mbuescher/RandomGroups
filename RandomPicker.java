// Fortune Teller

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RandomPicker extends JFrame
    implements ActionListener
{
//  private static final EasySound ding = new EasySound("ding2.wav");

  // Declare an array of "fortunes" (strings):
  private static final int NUM_NAMES = 6;
  private static final int LINE_LENGTH = 3;
  private static final String[] names = 
    {"August      ", "Brice       ", "Halle       ", "Kate        ", 
     "Margaret    ", "Rebecca     "};

  private JTextArea display;
  
  public RandomPicker()
  {
    super("Groups of Two");

    display = new JTextArea(5, 20);
    display.setBackground(Color.WHITE);
    display.setEditable(false);
    display.setText ("Press 'Make Groups' please.");

    JButton go = new JButton("Make Groups");
    go.addActionListener(this);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(display);
    c.add(go);
  }
  
  private void mixNames()
  {
      // Make ten swaps of the random order list
      for (int i = 1; i <= 10; i++)
      {
          int a = (int)(Math.random() * NUM_NAMES);
          int b = (int)(Math.random() * NUM_NAMES);
          
          // Swap a and b
          String temp = names[a];
          names[a] = names[b];
          names[b] = temp;
      }
  }
  
  private String namesString()
  {
      String ans = "";
      int count = 0;
      for (String s : names)
      {
           ans += s;
           count++;
           if (count % 3 == 0)
           {
               ans += "\n";
           }
      }
      return ans;
  }
    
    
  public void actionPerformed(ActionEvent e)
  {
    // Mix up the names array; print it in the new order:
    mixNames();
    display.setText(namesString());
//    ding.play();
  }

  public static void main(String[] args)
  {
    JFrame window = new RandomPicker();
    window.setBounds(300, 300, 400, 150);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true); 
  }
}
