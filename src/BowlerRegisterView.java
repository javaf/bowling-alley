import iiit.util.*;
import iiit.swing.*;
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
    JFrames.screenCenter(frame);
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
