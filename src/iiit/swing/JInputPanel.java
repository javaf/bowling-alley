package iiit.swing;


import java.awt.*;
import javax.swing.*;


public class JInputPanel extends JPanel {
  public JLabel label;
  public JTextField textField;
  
  public JInputPanel(String text, JTextField textField) {
    super();
    super.setLayout(new GridLayout(1, 2));
    super.add(label = new JLabel(text));
    super.add(this.textField = textField);
  }
  
  public JInputPanel(String text, int columns) {
    this(text, new JTextField("", columns));
  }
}
