package iiit.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JButtonPanel extends JPanel {
  public JButton button;
  
  public JButtonPanel(JButton button, ActionListener listener) {
    super();
    super.setLayout(new FlowLayout());
    button.addActionListener(listener);
    this.button = button;
    super.add(button);
  }
  
  public JButtonPanel(String text, ActionListener listener) {
    this(new JButton(text), listener);
  }
}
