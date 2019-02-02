import iiit.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class BowlerRegisterView extends EventEmitter implements ActionListener {
  private final JFrame frame;
  private final JInputPanel nickname, fullname, email;
  private final JButtonPanel register, cancel;

  
  public BowlerRegisterView() {
    frame = new JFrame("New Patron");
    frame.getContentPane().setLayout(new BorderLayout());
    ((JPanel)frame.getContentPane()).setOpaque(false);

    JPanel columns = new JPanel();
    columns.setLayout(new BorderLayout());

    JPanel patron = new JPanel();
    patron.setLayout(new GridLayout(3, 1));
    patron.setBorder(new TitledBorder("Your Info"));

    patron.add(nickname = new JInputPanel("Nickname", 15));
    patron.add(fullname = new JInputPanel("Fullname", 15));
    patron.add(email = new JInputPanel("Email", 15));

    JPanel buttons = new JPanel();
    buttons.setLayout(new GridLayout(4, 1));
    buttons.add(register = new JButtonPanel("Register", this));
    buttons.add(cancel = new JButtonPanel("Cancel", this));

    columns.add(patron, "Center");
    columns.add(buttons, "East");
    frame.getContentPane().add("Center", columns);
    frame.pack();

    Dimension size = frame.getSize();
    Dimension screen = (Toolkit.getDefaultToolkit()).getScreenSize();
    frame.setLocation((screen.width-size.width)/2, (screen.height-size.height)/2);
    frame.show();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(cancel.button)) {
      frame.hide();
    }
    if(e.getSource().equals(register.button)) {
      emit("end", new Bowler(
        nickname.textField.getText(),
        fullname.textField.getText(),
        email.textField.getText()
      ));
      frame.hide();
    }
  }
}


class JInputPanel extends JPanel {
  public JLabel label;
  public JTextField textField;
  
  public JInputPanel(String text, int columns) {
    super();
    super.setLayout(new GridLayout(1, 2));
    super.add(label = new JLabel(text));
    super.add(textField = new JTextField("", columns));
  }
}


class JButtonPanel extends JPanel {
  public JButton button;
  
  public JButtonPanel(String text, ActionListener listener) {
    super();
    super.setLayout(new FlowLayout());
    button = new JButton(text);
    button.addActionListener(listener);
    super.add(button);
  }
}
