package iiit.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JButtonPanel extends JPanel {
  public JButton button;
  
  public JButtonPanel(String text, ActionListener listener) {
    super();
    super.setLayout(new FlowLayout());
    button = new JButton(text);
    button.addActionListener(listener);
    super.add(button);
  }
}
