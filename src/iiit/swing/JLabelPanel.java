package iiit.swing;

import java.awt.*;
import javax.swing.*;


public class JLabelPanel extends JPanel {
  public JLabel label;
  
  public JLabelPanel(JLabel label) {
    super();
    super.setLayout(new FlowLayout());
    super.add(this.label = label);
  }
  
  public JLabelPanel(String text) {
    this(new JLabel(text));
  }
}
